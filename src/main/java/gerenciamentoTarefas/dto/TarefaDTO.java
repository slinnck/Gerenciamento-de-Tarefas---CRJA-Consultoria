package gerenciamentoTarefas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import gerenciamentoTarefas.domain.enums.RegistroDeDepartamento;

public class TarefaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private String departamento;
	private Integer duracao;
	private Boolean pessoaAlocada;
	private Boolean finalizado;
	private RegistroDeDepartamento registroDeDepartamento;
	private PessoaDTO pessoaDTO;
	
	public TarefaDTO() {
		
	}
	public TarefaDTO(Integer id, String titulo, String descricao, LocalDate prazo, String departamento, Integer duracao,
			Boolean pessoaAlocada, Boolean finalizado, RegistroDeDepartamento registroDeDepartamento,
			PessoaDTO pessoaDTO) {
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
		this.pessoaDTO = pessoaDTO;
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
	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}
	public void setPessoaDTO(PessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	
}