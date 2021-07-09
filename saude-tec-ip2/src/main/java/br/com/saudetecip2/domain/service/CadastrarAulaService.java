package br.com.saudetecip2.domain.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudetecip2.database.arquivoimplentation.AlunoRepository;
import br.com.saudetecip2.database.arquivoimplentation.Aluno_AulaRepository;
import br.com.saudetecip2.database.arquivoimplentation.AulaRepository;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.exceptions.AlunoJaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoEstaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;


public class CadastrarAulaService {

	AulaRepository aulaRepository = new AulaRepository();
	Aluno_AulaRepository aluno_AulaRepository = new Aluno_AulaRepository();
	AlunoRepository alunoRepository = new AlunoRepository();

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
	
	public void adicionarAlunoEmAula(String alunoCpf,String aulaId) throws AlunoJaMarcadoNaAulaException,AlunoNaoExisteException,AulaNaoExisteException {
		Aluno aluno = alunoRepository.findByCpf(alunoCpf);
		Aula aula = aulaRepository.findById(aulaId);
		
		
		if(aluno == null) {
			throw new AlunoNaoExisteException();
		}
		
		if(aula == null) {
			throw new AulaNaoExisteException();

		}
		
		String dado = aluno_AulaRepository.findByAulaAndAluno(aulaId, aluno.getId());
		
		if(dado != null) {
			throw new AlunoJaMarcadoNaAulaException();
		}
		
		aluno_AulaRepository.save(aluno.getId(), aulaId);
	}
	public void removerAlunoDeAula(String alunoCpf,String aulaId) throws AlunoNaoEstaMarcadoNaAulaException,AlunoNaoExisteException,AulaNaoExisteException  {
		Aluno aluno = alunoRepository.findByCpf(alunoCpf);
		Aula aula = aulaRepository.findById(aulaId);
		
		if(aluno == null) {
			throw new AlunoNaoExisteException();
		}
		
		if(aula == null) {
			throw new AulaNaoExisteException();

		}
	
		
		String dado = aluno_AulaRepository.findByAulaAndAluno(aulaId, aluno.getId());
	
		if (dado == null ) {
			throw new AlunoNaoEstaMarcadoNaAulaException();
		}
		
		aluno_AulaRepository.delete(aluno.getId(), aulaId);
	}
	
	public List<Aula> buscarAulasDeAluno(String id){
		 List<String> idsDeAulas=  aluno_AulaRepository.findAllByAluno(id);
		 List<Aula> aulasComAluno = new ArrayList<Aula>();
		 for(String idAula:idsDeAulas) {
			 try {
				aulasComAluno.add(this.buscarAula(idAula));
			} catch (AulaNaoExisteException e) {
				e.printStackTrace();
			}
		 }
		 
		 return aulasComAluno;
	}
}
