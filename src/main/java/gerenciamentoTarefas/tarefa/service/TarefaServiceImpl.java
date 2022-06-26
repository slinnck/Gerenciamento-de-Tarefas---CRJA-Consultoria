package gerenciamentoTarefas.tarefa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciamentoTarefas.domain.Tarefa;
import gerenciamentoTarefas.dto.TarefaDTO;
import gerenciamentoTarefas.repository.PessoaRepository;
import gerenciamentoTarefas.repository.TarefaRepository;

@Service
public class TarefaServiceImpl {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public Tarefa montaDomainTartefa(TarefaDTO tarefaDTO, Tarefa domain) {
		domain.setDepartamento(tarefaDTO.getDepartamento());
		domain.setDescricao(tarefaDTO.getDescricao());
		domain.setDuracao(tarefaDTO.getDuracao());
		domain.setFinalizado(tarefaDTO.getFinalizado());
		domain.setPrazo(tarefaDTO.getPrazo());
		return domain;
	}

}
