package gerenciamentoTarefas.services;

import gerenciamentoTarefas.domain.Tarefa;
import gerenciamentoTarefas.dto.TarefaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TarefaService {

    /**
     * @param tarefaDTO
     * Método responsável por adicionar uma nova tarefa
     * @return
     */
    String adicionarTarefa(TarefaDTO tarefaDTO);

    /**
     * @param id
     * Método que retorna a entidade tarefa
     * @return
     */
    Tarefa buscarEntidadeTarefa(Integer id);

    /**
     * @param id
     * Método que alocar uma tarefa a um pessoa
     * @return
     */
    String alocarPessoaTarefa(Integer id) throws Exception;

    /**
     * @param id
     * @param tarefaDTO
     * @return
     */
    String finalizarTarefa(Integer id, TarefaDTO tarefaDTO) throws Exception;

    /**
     * @param id
     * @return
     */
    Tarefa buscarTarefasPorPessoa(Integer id);

    /**
     * Método que retorna uma lista de tarefas pendentes
     * @return
     */
    List<TarefaDTO> listaTarefasExistentes();
}
