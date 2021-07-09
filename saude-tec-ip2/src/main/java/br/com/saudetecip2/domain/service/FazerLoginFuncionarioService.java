package br.com.saudetecip2.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saudetecip2.database.arquivoimplentation.FuncionarioRepository;
import br.com.saudetecip2.domain.model.Funcionario;

import br.com.saudetecip2.exceptions.ErroLoginFuncionarioException;


public class FazerLoginFuncionarioService {

	FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
	
	public Funcionario fazerLogin(String cpf, String senha) throws ErroLoginFuncionarioException {
		Funcionario funcionario = funcionarioRepository.findByCpfAndSenha(cpf, senha);
		
		if(funcionario == null) {
			throw new ErroLoginFuncionarioException();
		}
		return funcionario;
	}
	
	
}
