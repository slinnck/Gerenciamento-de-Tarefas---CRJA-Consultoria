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
	private Integer idDepartamento;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private String departamento;
	private Double duracao;

	@OneToOne
	@JoinColumn(name ="pessao_id", referencedColumnName = "id")
	private Pessoa pessoaAlocada;

	private Boolean finalizado;

	public Tarefa(LocalDate prazo, Double duracao) {
		this.prazo = prazo;
		this.duracao = duracao;
	}
}