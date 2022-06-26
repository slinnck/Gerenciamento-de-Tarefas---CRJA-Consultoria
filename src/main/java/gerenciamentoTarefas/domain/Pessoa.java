package gerenciamentoTarefas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import gerenciamentoTarefas.domain.enums.RegistroDeDepartamento;
import gerenciamentoTarefas.dto.TarefaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer departamento;

	public Pessoa() {
		
	}
	
	public Pessoa(Integer id, String nome, RegistroDeDepartamento departamento) {
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
