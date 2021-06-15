package br.com.saudetecip2.domain.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.model.Funcionario;

public interface AulaRepository extends JpaRepository<Aula, Long> {
	Aula findByDataAndProfessor(LocalDateTime data, Funcionario professor);
}
