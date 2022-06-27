package gerenciamentoTarefas.services;

import gerenciamentoTarefas.dto.DepartamentoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartamentoService {

    List<DepartamentoDTO> buscarDepartamentos();
}
