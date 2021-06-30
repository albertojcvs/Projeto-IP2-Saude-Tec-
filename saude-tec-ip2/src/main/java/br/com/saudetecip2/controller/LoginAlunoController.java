package br.com.saudetecip2.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.service.FazerLoginAlunoService;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;

@Controller
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
		
		System.out.println(idAluno + " | "+ senhaAluno);
		Aluno aluno = fazerLoginAlunoService.fazerLogin(idAluno, senhaAluno);
		if(aluno == null) {
			throw new ErroLoginAlunoException();
		}
		
		alunoLogado = aluno;
	}
	
	public void fazerLogout() {
		alunoLogado = null;}

}
