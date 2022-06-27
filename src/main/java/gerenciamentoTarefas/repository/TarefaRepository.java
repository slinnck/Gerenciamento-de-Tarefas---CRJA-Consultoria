package gerenciamentoTarefas.repository;

import gerenciamentoTarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import gerenciamentoTarefas.domain.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("SELECT t FROM Tarefa t WHERE t.pessoaAlocada.id = NULL ORDER BY t.prazo asc")
    List<Tarefa> listarTarefas();

    @Query("SELECT new Tarefa(t.prazo, AVG(t.duracao)) FROM Tarefa t WHERE t.pessoaAlocada.id = :id GROUP BY t.prazo")
    List<Tarefa> buscarMediaHorasGastasPorTarefas(@Param("id") Integer id);

    @Query("SELECT count (p) FROM Tarefa p WHERE p.idDepartamento = :id")
    Integer buscarTarefasPorDepartamento(@Param("id") Integer idDepartamento);

    @Query("SELECT sum (t.duracao) FROM Tarefa t WHERE t.pessoaAlocada.id = :id")
    Integer buscarTarefasPorPessoa(@Param("id") Integer idPessoa);
}
