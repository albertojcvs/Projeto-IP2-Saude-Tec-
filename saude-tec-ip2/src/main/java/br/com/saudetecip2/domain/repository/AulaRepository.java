package br.com.saudetecip2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.saudetecip2.domain.model.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long> {

}
