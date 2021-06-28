package br.com.saudetecip2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.domain.service.FazerLoginFuncionarioService;
import br.com.saudetecip2.exceptions.ErroLoginFuncionarioException;


@Controller
public class LoginFuncionarioController {
	@Autowired
	private FazerLoginFuncionarioService loginFuncionarioService;
	private Funcionario funcionarioLogado;
	
	private static LoginFuncionarioController instance;
	
	private LoginFuncionarioController() {}
	
	public static LoginFuncionarioController getInstace() {
		if(instance == null) {
			instance = new LoginFuncionarioController();
		}
		return instance;
	}
	
	
	public void fazerLogin(Long id,String senha) throws ErroLoginFuncionarioException{
		Funcionario funcionario = loginFuncionarioService.fazerLogin(id, senha);
		funcionarioLogado = funcionario;
	}
	
	public void fazerLogout() {
		funcionarioLogado = null;
	}
	
	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}
}
