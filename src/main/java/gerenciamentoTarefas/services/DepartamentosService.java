package gerenciamentoTarefas.services;

import gerenciamentoTarefas.dto.DepartamentoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartamentosService {

    /**
     * Método utilizado para retornar os departamentos registrados
     * @return
     */
    List<DepartamentoDTO> buscarDepartamentos();
}
