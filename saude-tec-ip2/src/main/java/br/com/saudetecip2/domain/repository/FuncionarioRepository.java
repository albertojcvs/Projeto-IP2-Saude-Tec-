package br.com.saudetecip2.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findAllByCargo(CargoFuncionario cargo);
	Funcionario findByCpf(String cpf);
}
