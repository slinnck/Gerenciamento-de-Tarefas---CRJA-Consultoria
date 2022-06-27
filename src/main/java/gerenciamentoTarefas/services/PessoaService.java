package gerenciamentoTarefas.services;

import gerenciamentoTarefas.domain.Pessoa;
import gerenciamentoTarefas.dto.PessoaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PessoaService {
	
	/**
	 * @param pessoaDto
	 * Método utilizado para cadastrar uma pessoa
	 * return @pessoaDTO
	 */
	String cadastrarPessoa(PessoaDTO pessoaDto);
	
	/**
	 * @param id, pessoaDTO
	 * Método utilizado para editar uma pessoa
	 * return @pessoaDTO
	 */
	String editarPessoa(Integer id, PessoaDTO pessoaDTO);
	
	/**
	 * @param id
	 * Método utlizado para deletar uma pessoa
	 * return id
	 */
	String deletarPessoa(Integer id);

	/**
	 *
	 * @param id
	 * Método que busca a entidade
	 * @return
	 */
	Pessoa buscarEntidadePessoa(Integer id);

	/**
	 * @param idDepartamento
	 * @return
	 * @throws Exception
	 */
	Pessoa buscarPessoaPorIdDepartamento(Integer idDepartamento) throws Exception;


	/**
	 * Método que retorna uma lista de Pessoas, seus departamentos e e total de horas gastas por tarefa
	 * @return
	 */
	List<PessoaDTO> listPessoas();

	/**
	 * Método que retorno uma lista de pessoas por nome, período e média de horas gastas por tarefa
	 * @return
	 */
	List<PessoaDTO> buscarPessoaPorPeriodo();

}
