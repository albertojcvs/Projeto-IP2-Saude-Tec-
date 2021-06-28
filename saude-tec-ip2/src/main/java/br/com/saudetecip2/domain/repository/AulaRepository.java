package br.com.saudetecip2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.saudetecip2.domain.model.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
	
}
