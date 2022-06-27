package gerenciamentoTarefas.services.impl;

import gerenciamentoTarefas.domain.Pessoa;
import gerenciamentoTarefas.domain.Tarefa;
import gerenciamentoTarefas.dto.TarefaDTO;
import gerenciamentoTarefas.repository.TarefaRepository;
import gerenciamentoTarefas.services.PessoaService;
import gerenciamentoTarefas.services.TarefaService;
import gerenciamentoTarefas.services.exceptions.ObjectNotFoundException;
import gerenciamentoTarefas.shared.MensagenRetorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    PessoaService pessoaService;

    public Tarefa montarEntidade(TarefaDTO tarefaDTO, Tarefa tarefa) {
        if (Objects.nonNull(tarefaDTO.getPessoaAlocada())) {
            tarefa.setPessoaAlocada(pessoaService.buscarEntidadePessoa(tarefaDTO.getPessoaAlocada()));
        }
        tarefa.setIdDepartamento(tarefaDTO.getIdDepartamento());
        tarefa.setPrazo(tarefaDTO.getPrazo());
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDuracao(tarefaDTO.getDuracao());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setDepartamento(tarefaDTO.getDescricaoDepartamento());
        tarefa.setFinalizado(tarefaDTO.getFinalizado());
        return tarefa;
    }

    @Override
    public Tarefa buscarEntidadeTarefa(Integer id) {
        Optional<Tarefa> retorno = tarefaRepository.findById(id);
        return retorno.orElseThrow(() -> new ObjectNotFoundException(
                "Tarefa não encontrada! Id: " + id));
    }

    @Override
    public Tarefa buscarTarefasPorPessoa(Integer id) {
        Optional<Tarefa> retorno = tarefaRepository.findById(id);
        return retorno.orElseThrow(() -> new ObjectNotFoundException(
                "Id não encontrado: " + id
        ));
    }

    @Override
    public String adicionarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        montarEntidade(tarefaDTO, tarefa);
        tarefaRepository.save(tarefa);
        return MensagenRetorno.MENSAGEM_SUCESS;
    }

    @Override
    public String alocarPessoaTarefa(Integer id) throws Exception {
        Tarefa tarefa = buscarEntidadeTarefa(id);
        Pessoa pessoa = pessoaService.buscarPessoaPorIdDepartamento(tarefa.getIdDepartamento());
        tarefa.setPessoaAlocada(pessoa);
        tarefaRepository.save(tarefa);
        return MensagenRetorno.MENSAGEM_UPDATE;

    }

    @Override
    public String  finalizarTarefa(Integer id, TarefaDTO tarefaDTO) throws Exception {
        Tarefa tarefa = buscarEntidadeTarefa(id);
        montarEntidade(tarefaDTO, tarefa);
        tarefaRepository.save(tarefa);
        return MensagenRetorno.MENSAGEM_UPDATE;
    }

    @Override
    public List<TarefaDTO> listaTarefasExistentes() {
        List<Tarefa> tarefas = tarefaRepository.listarTarefas();
        List<TarefaDTO> tarefasDTO = new ArrayList<>();
        int index = 0;
        for (Tarefa tf : tarefas) {
            TarefaDTO dto = new TarefaDTO(tf);
            tarefasDTO.add(dto);
            if (index == 2) {
                return  tarefasDTO;
            } index++;
        }
        return tarefasDTO;
    }
}
