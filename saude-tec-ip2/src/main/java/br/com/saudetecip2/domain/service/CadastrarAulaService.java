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
	public void removerAula(Long id) throws AulaNaoExisteException{
		Aula aulaParaRemover = aulaRepository.getById(id);
		
		if(aulaParaRemover == null) {
			throw new AulaNaoExisteException();
		}
		
		aulaRepository.delete(aulaParaRemover);
	} 

	public void atualizarAula(Aula aula) throws AulaNaoExisteException {
		Aula aulaParaAtualizar = aulaRepository.getById(aula.getId());
		if (aulaParaAtualizar == null) {
			throw new AulaNaoExisteException();
		}
		aulaParaAtualizar = aula;
		aulaRepository.save(aulaParaAtualizar);
	}

	public Aula buscarAula(Long id) throws AulaNaoExisteException{
		
		Aula aulaBuscada = aulaRepository.getById(id);
		if(aulaBuscada == null) {
			throw new AulaNaoExisteException();
		}
		return aulaBuscada;
		
	}
	public List<Aula> buscarAulas() {
		return aulaRepository.findAll();
	}

	public List<Aula> buscarAulasDe(Long alunoId) {
		return aulaRepository.findByAluno(alunoId);
	}
}
