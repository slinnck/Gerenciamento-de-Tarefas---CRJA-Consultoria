package gerenciamentoTarefas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gerenciamentoTarefas.domain.Tarefa;
import gerenciamentoTarefas.domain.enums.RegistroDeDepartamento;
import gerenciamentoTarefas.dto.MediaPessoaDTO;
import gerenciamentoTarefas.services.PessoaService;
import gerenciamentoTarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciamentoTarefas.domain.Pessoa;
import gerenciamentoTarefas.dto.PessoaDTO;
import gerenciamentoTarefas.repository.PessoaRepository;
import gerenciamentoTarefas.repository.TarefaRepository;
import gerenciamentoTarefas.services.exceptions.ObjectNotFoundException;
import gerenciamentoTarefas.shared.MensagenRetorno;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    private Pessoa montarEntidade(PessoaDTO pessoaDto, Pessoa entidade) {
        entidade.setNome(pessoaDto.getNome());
        entidade.setIdDepartamento(pessoaDto.getIdDepartamento());
        return entidade;
    }

    @Override
    public Pessoa buscarEntidadePessoa(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Pessoa não encontrada! Id: " + id));
    }

    public PessoaDTO montarDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setIdDepartamento(pessoa.getIdDepartamento());
        pessoaDTO.setNome(pessoa.getNome());
        return pessoaDTO;
    }

    @Override
    public String cadastrarPessoa(PessoaDTO pessoaDto) {
        Pessoa pessoa = new Pessoa();
        pessoaRepository.save(montarEntidade(pessoaDto, pessoa));
        return MensagenRetorno.MENSAGEM_SUCESS;
    }

    public String editarPessoa(Integer id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = buscarEntidadePessoa(id);
        montarEntidade(pessoaDTO, pessoa);
        pessoaRepository.save(pessoa);
        return MensagenRetorno.MENSAGEM_UPDATE;
    }

    public String deletarPessoa(Integer id) {
        pessoaRepository.delete(buscarEntidadePessoa(id));
        return MensagenRetorno.MENSAGEM_DELETE;
    }

    @Override
    public Pessoa buscarPessoaPorIdDepartamento(Integer idDepartamento) throws Exception {
        List<Pessoa> pessoas = pessoaRepository.buscarPessoaPorIdDepartamento(idDepartamento);
        if (!pessoas.isEmpty()) {
            Pessoa pessoa = pessoas.get(0);
            return pessoa;
        } else {
            throw new ObjectNotFoundException("Não existe registro de pessoa neste departamento.");
        }
    }

    @Override
    public List<PessoaDTO> listPessoas() {
        List<PessoaDTO> listaPessoasDTO = new ArrayList<>();
        List<Pessoa> retornoLista = pessoaRepository.findAll();
        if (!retornoLista.isEmpty()) {
            for (Pessoa pessoa : retornoLista) {
                PessoaDTO pessoaDTO = montarDTO(pessoa);
                pessoaDTO.setDescricaoDepartamento(RegistroDeDepartamento.toEnum(pessoaDTO.getIdDepartamento()).getDescricao());
                pessoaDTO.setTotalHorasGastas(tarefaRepository.buscarTarefasPorPessoa(pessoa.getId()));
                listaPessoasDTO.add(pessoaDTO);
            }
            return listaPessoasDTO;
        } else {
            throw new ObjectNotFoundException(MensagenRetorno.MENSAGEM_EMPTY_LIST);
        }
    }

    @Override
    public List<PessoaDTO> buscarPessoaPorPeriodo() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDTO> pessoaDTO = new ArrayList<>();
        pessoas.stream().forEach((p) -> {
            PessoaDTO pessoa = new PessoaDTO(p);
            List<Tarefa> tarefasPessoa = tarefaRepository.buscarMediaHorasGastasPorTarefas(p.getId());
            MediaPessoaDTO media = new MediaPessoaDTO();
            List<MediaPessoaDTO> listaDeMedias = new ArrayList<>();
            tarefasPessoa.stream().forEach((tp) -> {
                media.setPeriodo(tp.getPrazo().getYear());
                media.setMediaHoras(tp.getDuracao());
                listaDeMedias.add(media);
            });
            pessoa.setMedia(listaDeMedias);
            pessoaDTO.add(pessoa);
        });
        return pessoaDTO;
    }
}
