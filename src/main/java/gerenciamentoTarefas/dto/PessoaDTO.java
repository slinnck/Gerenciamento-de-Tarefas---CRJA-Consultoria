package gerenciamentoTarefas.dto;

import java.io.Serializable;
import java.util.List;

import gerenciamentoTarefas.domain.enums.RegistroDeDepartamento;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer departamento;
	
	public PessoaDTO() {
		
	}

	public PessoaDTO(Integer id, String nome, RegistroDeDepartamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.departamento = departamento.getCod();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RegistroDeDepartamento getDepartamento() {
		return RegistroDeDepartamento.toEnum(departamento);
	}

	public void setDepartamento(RegistroDeDepartamento departamento) {
		this.departamento = departamento.getCod();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
