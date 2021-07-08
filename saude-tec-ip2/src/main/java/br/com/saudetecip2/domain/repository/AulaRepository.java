package br.com.saudetecip2.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.model.Funcionario;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
//	Aula findByDataAndProfessor(LocalDateTime data, Funcionario professor);
	List<Aula> findByAluno(Long alunoId);
}
