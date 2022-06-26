package gerenciamentoTarefas.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import gerenciamentoTarefas.domain.enums.RegistroDeDepartamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private String departamento;
	private Integer duracao;
	private Boolean pessoaAlocada;
	private Boolean finalizado;
	private RegistroDeDepartamento registroDeDepartamento;
	
	@OneToOne()
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	public Tarefa() {
		
	}
	public Tarefa(Integer id, String titulo, String descricao, LocalDate prazo, String departamento, Integer duracao,
			Boolean pessoaAlocada, Boolean finalizado, RegistroDeDepartamento registroDeDepartamento, Pessoa pessoa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.departamento = departamento;
		this.duracao = duracao;
		this.pessoaAlocada = pessoaAlocada;
		this.finalizado = finalizado;
		this.registroDeDepartamento = registroDeDepartamento;
		this.pessoa = pessoa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getPrazo() {
		return prazo;
	}
	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	public Boolean getPessoaAlocada() {
		return pessoaAlocada;
	}
	public void setPessoaAlocada(Boolean pessoaAlocada) {
		this.pessoaAlocada = pessoaAlocada;
	}
	public Boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	public RegistroDeDepartamento getRegistroDeDepartamento() {
		return registroDeDepartamento;
	}
	public void setRegistroDeDepartamento(RegistroDeDepartamento registroDeDepartamento) {
		this.registroDeDepartamento = registroDeDepartamento;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}