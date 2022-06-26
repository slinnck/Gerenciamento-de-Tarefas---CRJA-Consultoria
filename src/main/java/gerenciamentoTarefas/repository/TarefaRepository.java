package gerenciamentoTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciamentoTarefas.domain.Pessoa;

public interface TarefaRepository extends JpaRepository<Pessoa, Long> {

}
