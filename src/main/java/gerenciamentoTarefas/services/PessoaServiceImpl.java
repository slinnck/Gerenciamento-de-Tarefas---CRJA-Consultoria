package gerenciamentoTarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciamentoTarefas.domain.Pessoa;
import gerenciamentoTarefas.dto.PessoaDTO;
import gerenciamentoTarefas.repository.PessoaRepository;
import gerenciamentoTarefas.repository.TarefaRepository;
import gerenciamentoTarefas.services.exceptions.ObjectNotFoundException;
import gerenciamentoTarefas.shared.mensagenRetorno;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository; 
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@Override
	public String cadastrarPessoa(PessoaDTO pessoaDto) { 
        Pessoa pessoa = new Pessoa();
        pessoaRepository.save(montarEntidade(pessoaDto, pessoa));
        return mensagenRetorno.MENSAGEM_SUCESS;
    }
	
	public String editarPessoa(Integer id, PessoaDTO pessoaDTO) {
		Pessoa pessoa = buscarEntidade(id);
		montarEntidade(pessoaDTO, pessoa);
		pessoaRepository.save(pessoa);
		return mensagenRetorno.MENSAGEM_UPDATE;	
	}
	
	public String deletarPessoa(Integer id) {
		pessoaRepository.delete(buscarEntidade(id));
		return mensagenRetorno.MENSAGEM_DELETE;
	}


    private Pessoa montarEntidade(PessoaDTO pessoaDto, Pessoa domain) {
    	domain.setNome(pessoaDto.getNome());
    	domain.setDepartamento(pessoaDto.getDepartamento());
        return domain;
    }

    public Pessoa buscarEntidade(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Pessoa não encontrada! Id: " + id));
    }
}
