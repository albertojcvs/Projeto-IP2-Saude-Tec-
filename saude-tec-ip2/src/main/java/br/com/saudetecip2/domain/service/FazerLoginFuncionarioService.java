package br.com.saudetecip2.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.domain.repository.FuncionarioRepository;
import br.com.saudetecip2.exceptions.ErroLoginFuncionarioException;

@Service
public class FazerLoginFuncionarioService {
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Funcionario fazerLogin(String cpf, String senha) throws ErroLoginFuncionarioException {
		Funcionario funcionario = funcionarioRepository.findByCpfAndSenha(cpf, senha);
		
		if(funcionario == null) {
			throw new ErroLoginFuncionarioException();
		}
		return funcionario;
	}
	
	
}
