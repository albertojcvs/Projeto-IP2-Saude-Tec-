package br.com.saudetecip2.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.domain.service.FazerLoginFuncionarioService;
import br.com.saudetecip2.exceptions.ErroLoginFuncionarioException;


@Controller
public class LoginFuncionarioController {
	@Autowired
	private FazerLoginFuncionarioService loginFuncionarioService;
	private Funcionario funcionarioLogado;
	
	private Funcionario funcionario01 = new Funcionario("Alberto", "11111111", Date.valueOf(LocalDate.of(2001,06,16)), CargoFuncionario.ATENDENTE, StatusDoFuncionario.CONTRATADO, 1000.00, "123");
	private Funcionario funcionario02 = new Funcionario("Roberto", "22222222", Date.valueOf(LocalDate.of(1998,02,23)), CargoFuncionario.PROFESSOR, StatusDoFuncionario.CONTRATADO, 2000.00, "123");
	private Funcionario funcionario03 = new Funcionario("Ana", "33333333", Date.valueOf(LocalDate.of(1988,05,26)), CargoFuncionario.GERENTE, StatusDoFuncionario.CONTRATADO, 3000.00, "123");
	
	
	private static LoginFuncionarioController instance;
	
	private LoginFuncionarioController() {}
	
	public static LoginFuncionarioController getInstace() {
		if(instance == null) {
			instance = new LoginFuncionarioController();
		}
		return instance;
	}
	
	
	public void fazerLogin(Long id,String senha) throws ErroLoginFuncionarioException{
		Funcionario funcionario;
		if(id.equals(new Long(1))) {
		 funcionario = funcionario01;
		}else if(id.equals(new Long(2))) {
			funcionario = funcionario02;
		}else if(id.equals(new Long(3))){
			funcionario = funcionario03;
		}else {
			throw new ErroLoginFuncionarioException();
		}
//		Funcionario funcionario = loginFuncionarioService.fazerLogin(id, senha);
		funcionarioLogado = funcionario;
	}
	
	public void fazerLogout() {
		funcionarioLogado = null;
	}
	
	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}
}
