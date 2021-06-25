package br.com.saudetecip2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.service.FazerLoginAlunoService;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;

public class LoginAlunoController {
	@Autowired
	private FazerLoginAlunoService fazerLoginAlunoService;
	
	private static LoginAlunoController instance;
	private Aluno alunoLogado;
	
	public static LoginAlunoController getInstance() {
		if(instance == null) {
			instance = new LoginAlunoController();
		}
		return instance;
		
	}
	
	private LoginAlunoController() {}
	
	public Aluno getAlunoLogado() {
		return alunoLogado;
	}
	
	public void fazerLogin(Long idAluno, String senhaAluno) throws ErroLoginAlunoException {
		Aluno aluno = fazerLoginAlunoService.fazerLogin(idAluno, senhaAluno);
		if(aluno == null) {
			throw new ErroLoginAlunoException() ;
		}
		
		alunoLogado = aluno;
	}
	
	public void fazerLogout() {
		alunoLogado = null;}

}
