package gerenciamentoTarefas.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import gerenciamentoTarefas.domain.Pessoa;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Integer idDepartamento;
	private String descricaoDepartamento;
	private Integer totalHorasGastas;
	private List<MediaPessoaDTO> media;

	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.idDepartamento = pessoa.getIdDepartamento();
	}

}
	

