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
	
	public Funcionario fazerLogin(Long id, String senha) throws ErroLoginFuncionarioException {
		Funcionario funcionario = funcionarioRepository.findByIdAndSenha(id, senha);
		
		if(funcionario == null) {
			throw new ErroLoginFuncionarioException();
		}
		return funcionario;
	}
	
	
}
