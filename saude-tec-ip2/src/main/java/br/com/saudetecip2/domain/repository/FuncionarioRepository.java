package br.com.saudetecip2.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findAllByCargo(CargoFuncionario cargo);
	Funcionario findByCpf(String cpf);
	
	Funcionario findByIdAndSenha(Long id, String senha);
}
