package gerenciamentoTarefas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaPessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double mediaHoras;
    private int periodo;

}
