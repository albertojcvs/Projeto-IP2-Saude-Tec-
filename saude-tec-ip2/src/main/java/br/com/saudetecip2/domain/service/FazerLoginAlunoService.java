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
	
	public Aluno fazerLogin(String cpfAluno,String senhaAluno) throws ErroLoginAlunoException {
		
		System.out.println(cpfAluno +" | "+ senhaAluno);
		Aluno aluno = alunoRepository.findByCpfAndSenha(cpfAluno, senhaAluno);
		
		if(aluno == null) {
			throw new ErroLoginAlunoException();
		}
		
		return aluno;
		
	}

	
}
