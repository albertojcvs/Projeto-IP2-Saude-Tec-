package br.com.saudetecip2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.service.CadastrarAulaService;
import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;


@Controller
public class Aulacontroller {

	@Autowired
	CadastrarAulaService aulaService;

	public void criarAula(Aula aula) throws AulaJaExisteException {
		//aulaService.cadastrarAula(aula);
	}

	public void deletarAula(Aula aula) throws AulaNaoExisteException {
		aulaService.removerAula(aula);
	}

	public void atualizarAula(Aula aula) throws AulaNaoExisteException {
		aulaService.atualizarAula(aula);
	}

	public List<Aula> buscarTodasAulas() {		
		return aulaService.buscarAulas();
	}

}
