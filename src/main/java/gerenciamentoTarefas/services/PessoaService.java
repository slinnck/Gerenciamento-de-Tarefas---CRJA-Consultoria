package gerenciamentoTarefas.services;

import gerenciamentoTarefas.domain.Pessoa;
import gerenciamentoTarefas.dto.PessoaDTO;


public interface PessoaService {
	
	/*
	 * Método utilizado para cadastrar uma pessoa
	 * return @pessoaDTO
	 */
	public String cadastrarPessoa(PessoaDTO pessoaDto);
	
	/*
	 * Método utilizado para editar uma pessoa
	 * return @pessoaDTO
	 */
	public String editarPessoa(Integer id, PessoaDTO pessoaDTO);
	
	/*
	 * Método utlizado para deletar uma pessoa
	 * return id
	 */
	public String deletarPessoa(Integer id);

}
