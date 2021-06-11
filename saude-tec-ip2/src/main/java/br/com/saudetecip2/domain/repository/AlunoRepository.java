package br.com.saudetecip2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.saudetecip2.domain.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  Aluno findByNome(String nome);
}
