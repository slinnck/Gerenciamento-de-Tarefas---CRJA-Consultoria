package gerenciamentoTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciamentoTarefas.dto.TarefaDTO;

public interface TarefaRepository extends JpaRepository<TarefaDTO, Integer> {

}
