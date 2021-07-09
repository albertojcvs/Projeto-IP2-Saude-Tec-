package br.com.saudetecip2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.domain.service.CadastrarFuncionarioService;
import br.com.saudetecip2.exceptions.FuncionarioJaExisteException;
import br.com.saudetecip2.exceptions.FuncionarioNaoExisteException;



public class FuncionarioController {
	
	CadastrarFuncionarioService funcionarioService = new CadastrarFuncionarioService();

	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
		funcionarioService.cadastrarFucionario(funcionario);
	}

	
	public void removerFuncionario(String cpf) throws FuncionarioNaoExisteException {
		funcionarioService.removerFuncionario(cpf);
	}

	public void atualizarFuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
		funcionarioService.atualizarFuncionario(funcionario);
	}

	public List<Funcionario> buscarTodosFuncionarios() {
		return funcionarioService.buscarFuncionarios();
	}

	public List<Funcionario> buscarFuncionariosPorCargo(CargoFuncionario cargo) {
		return funcionarioService.buscarPorCargo(cargo);
	}

}
