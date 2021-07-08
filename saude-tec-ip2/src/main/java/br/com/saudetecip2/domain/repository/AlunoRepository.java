package br.com.saudetecip2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.saudetecip2.domain.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  Aluno findByNome(String nome);
  Aluno findByCpfAndSenha(String cpf, String senha);
  Aluno findByCpf(String cpf);
}
