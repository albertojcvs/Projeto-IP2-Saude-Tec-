package br.com.saudetecip2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.service.CadastrarAulaService;
import br.com.saudetecip2.exceptions.AlunoJaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoEstaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;


public class Aulacontroller {


	CadastrarAulaService aulaService = new CadastrarAulaService();

	public void criarAula(Aula aula) throws AulaJaExisteException {
		aulaService.cadastrarAula(aula);
	}

	public void deletarAula(String id) throws AulaNaoExisteException{
		aulaService.removerAula(id);
	}

	public void atualizarAula(Aula aula) throws AulaNaoExisteException {
		aulaService.atualizarAula(aula);
	}
	public Aula buscarAula(String id) throws AulaNaoExisteException {
		return aulaService.buscarAula(id);
	}

	public List<Aula> buscarTodasAulas() {		
		return aulaService.buscarAulas();
	}
	
	public void adicionarAlunoEmAula(String alunoCpf,String aulaId) throws AlunoJaMarcadoNaAulaException, AlunoNaoExisteException, AulaNaoExisteException {
		aulaService.adicionarAlunoEmAula(alunoCpf, aulaId);
	}
	public void removerAlunoDeAula(String alunoCpf,String aulaId) throws AlunoNaoEstaMarcadoNaAulaException, AlunoNaoExisteException, AulaNaoExisteException {
		aulaService.removerAlunoDeAula(alunoCpf, aulaId);
	}
	
	public List<Aula> buscarAulasDeAluno(String id) {
		return aulaService.buscarAulasDeAluno(id);
	}
	

}
