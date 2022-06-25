package gerenciamentoTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciamentoTarefas.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
