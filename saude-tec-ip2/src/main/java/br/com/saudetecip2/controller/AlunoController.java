package br.com.saudetecip2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.service.CadastrarAlunoService;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;

public class AlunoController {
	
	@Autowired
	CadastrarAlunoService alunoService;
	
	
	public void adicionarAluno(Aluno aluno) {
		alunoService.cadastrarAluno(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		alunoService.removerAluno(aluno);
	}
	public void removerAluno(Long id) throws AlunoNaoExisteException {
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
}
