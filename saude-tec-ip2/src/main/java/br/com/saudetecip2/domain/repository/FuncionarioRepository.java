package br.com.saudetecip2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.saudetecip2.domain.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
