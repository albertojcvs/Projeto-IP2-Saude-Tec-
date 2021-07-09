package br.com.saudetecip2.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.service.FazerLoginAlunoService;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;

public class LoginAlunoController {

	FazerLoginAlunoService fazerLoginAlunoService = new FazerLoginAlunoService();
//	private Aluno aluno01 = new Aluno("01",StatusDaMensalidadeDoAluno.PAGO,"Andre","4444444",Date.valueOf(LocalDate.of(2002, 04, 30)),"123");
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
	
	public void fazerLogin(String cpfAluno, String senhaAluno) throws ErroLoginAlunoException {
		
		Aluno aluno = fazerLoginAlunoService.fazerLogin(cpfAluno, senhaAluno);
		if(aluno == null) {
			throw new ErroLoginAlunoException();
		}
		
		alunoLogado = aluno;
	}
	
	public void fazerLogout() {
		alunoLogado = null;}

}
