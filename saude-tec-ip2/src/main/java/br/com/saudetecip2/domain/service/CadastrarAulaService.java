package br.com.saudetecip2.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.repository.AulaRepository;
import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;

@Service
public class CadastrarAulaService {
	@Autowired
	AulaRepository aulaRepository;
	
//	public void cadastrarAula(Aula aula)throws AulaJaExisteException {
//		Aula aulaExistente = aulaRepository.findByDataAndProfessor(aula.getData(), aula.getProfessor());
//			
//		if (aulaExistente != null) {
//			throw new AulaJaExisteException();
//		}
//		aulaRepository.save(aula);
//	}
	public void removerAula(Aula aula) throws AulaNaoExisteException {
		Optional<Aula> aulaExistente = aulaRepository.findById(aula.getId());
		if (aulaExistente == null) {
			throw new AulaNaoExisteException();
		}
		aulaRepository.delete(aula);
	}
	public void atualizarAula(Aula aula) throws AulaNaoExisteException {
		Aula aulaParaAtualizar = aulaRepository.getById(aula.getId());
		if (aulaParaAtualizar == null) {
			throw new AulaNaoExisteException();
		}
	aulaParaAtualizar = aula;
	aulaRepository.save(aulaParaAtualizar);
	}
	public List<Aula> buscarAulas() {
		return aulaRepository.findAll();
		}
	}

