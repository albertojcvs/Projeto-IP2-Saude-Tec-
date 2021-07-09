package br.com.saudetecip2.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudetecip2.database.arquivoimplentation.AulaRepository;
import br.com.saudetecip2.domain.model.Aula;

import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;


public class CadastrarAulaService {

	AulaRepository aulaRepository = new AulaRepository();

	public void cadastrarAula(Aula aula)throws AulaJaExisteException {
		Aula aulaExistente = aulaRepository.findByDataAndProfessor(aula.getData(), aula.getProfessor());
			
		if (aulaExistente != null) {
			throw new AulaJaExisteException();
		}
		aulaRepository.save(aula);
	}
	public void removerAula(String id) throws AulaNaoExisteException{
		Aula aulaParaRemover = aulaRepository.findById(id);
		
		if(aulaParaRemover == null) {
			throw new AulaNaoExisteException();
		}
		
		aulaRepository.deleteById(id);
	} 

	public void atualizarAula(Aula aula) throws AulaNaoExisteException {
		Aula aulaParaAtualizar = aulaRepository.findById(aula.getId());
		if (aulaParaAtualizar == null) {
			throw new AulaNaoExisteException();
		}
		aulaParaAtualizar = aula;
		aulaRepository.update(aulaParaAtualizar);
	}

	public Aula buscarAula(String id) throws AulaNaoExisteException{
		
		Aula aulaBuscada = aulaRepository.findById(id);
		if(aulaBuscada == null) {
			throw new AulaNaoExisteException();
		}
		return aulaBuscada;
		
	}
	public List<Aula> buscarAulas() {
		return aulaRepository.findAll();
	}
}
