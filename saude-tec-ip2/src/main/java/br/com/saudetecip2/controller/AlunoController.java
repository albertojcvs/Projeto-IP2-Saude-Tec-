package br.com.saudetecip2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.service.CadastrarAlunoService;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;


public class AlunoController {
	
	
	CadastrarAlunoService alunoService = new CadastrarAlunoService();
	
	
	public void adicionarAluno(Aluno aluno) {
		alunoService.cadastrarAluno(aluno);
	}
	
	public void removerAluno(String id) throws AlunoNaoExisteException {
		System.out.println("bbbbbbbbbb");
		alunoService.removerAluno(id);
	}
	
	public void atualizarAluno(Aluno aluno) {
		alunoService.atualizarAluno(aluno);
	}
	
	public List<Aluno> buscarTodosAlunos(){
		return alunoService.buscarAlunos();
	}
	public Aluno buscarAluno(Aluno aluno) throws IOException {
		return alunoService.buscarAluno(aluno);
	}
	
	public Aluno buscarAluno(String cpf ) throws AlunoNaoExisteException {
		return alunoService.buscarAluno(cpf);
	}
	public void mudarStatusDaMensalidadeDoAluno(String cpf,StatusDaMensalidadeDoAluno statusDaMensalidade) throws AlunoNaoExisteException {
		alunoService.mudarStatusDaMensalidadeDoAluno(cpf, statusDaMensalidade);
	}
}
