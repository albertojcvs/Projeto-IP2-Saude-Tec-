package br.com.saudetecip2.domain.service;

import br.com.saudetecip2.database.arquivoimplentation.AlunoRepository;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;

public class FazerLoginAlunoService {
  
	AlunoRepository alunoRepository = new AlunoRepository();
	
	public Aluno fazerLogin(String cpfAluno,String senhaAluno) throws ErroLoginAlunoException {
		
		System.out.println(cpfAluno +" || "+ senhaAluno);
		Aluno aluno = alunoRepository.findByCpfAndSenha(cpfAluno, senhaAluno);
		System.out.println(aluno.getNome());
		
		if(aluno == null) {
			throw new ErroLoginAlunoException();
		}
		
		return aluno;
		
	}

	
}
