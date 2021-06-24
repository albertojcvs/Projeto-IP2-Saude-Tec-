package br.com.saudetecip2.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;

@Service
public class FazerLoginAlunoService {
	@Autowired
	AlunoRepository alunoRepository;
	
	public Aluno fazerLogin(Long idAluno,String senhaAluno) throws ErroLoginAlunoException {
		Aluno aluno = alunoRepository.findByIdAndSenha(idAluno, senhaAluno);
		
		if(aluno != null) {
			throw new ErroLoginAlunoException();
		}
		
		return aluno;
		
	}
	
	public void fazerLogout() {
		
	}
	
	
}
