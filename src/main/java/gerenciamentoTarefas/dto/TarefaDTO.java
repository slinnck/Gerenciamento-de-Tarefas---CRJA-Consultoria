package gerenciamentoTarefas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import gerenciamentoTarefas.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idDepartamento;
	private String titulo;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate prazo;
	private String descricaoDepartamento;
	private Double duracao;
	private Integer pessoaAlocada;
	private Boolean finalizado;

	public TarefaDTO(Tarefa tarefa) {
		this.idDepartamento = tarefa.getIdDepartamento();
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.prazo = tarefa.getPrazo();
		this.descricaoDepartamento = tarefa.getDepartamento();
		this.duracao = tarefa.getDuracao();
		this.finalizado = tarefa.getFinalizado();
	}
}