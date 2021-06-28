package br.com.saudetecip2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.domain.service.CadastrarFuncionarioService;
import br.com.saudetecip2.exceptions.FuncionarioJaExisteException;
import br.com.saudetecip2.exceptions.FuncionarioNaoExisteException;

public class FuncionarioController {
	@Autowired
	CadastrarFuncionarioService funcionarioService;

	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
		funcionarioService.cadastrarFucionario(funcionario);
	}

	public void removerFuncinario(Funcionario funcionario) throws FuncionarioNaoExisteException {
		funcionarioService.removerFuncionario(funcionario);
	}
	
	public void removerFuncionario(Long id) throws FuncionarioNaoExisteException {
		funcionarioService.removerFuncionario(id);
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
