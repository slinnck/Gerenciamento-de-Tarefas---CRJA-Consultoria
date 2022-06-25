package gerenciamentoTarefas.dto;

import java.io.Serializable;
import java.time.LocalDate;

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


}