package br.com.saudetecip2.domain.service;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;

@Service
public class CadastrarAlunoService {

  @Autowired
  AlunoRepository alunoRepository;
  
  public void cadastrarAluno(Aluno aluno) {
	  System.out.println("no service");
	  System.out.println(aluno.getCpf());
	  System.out.println(aluno.getNome());
    Aluno alunoExistente = alunoRepository.findByNome(aluno.getNome());
    if(alunoExistente != null && !alunoExistente.equals(aluno)) {
        
     alunoRepository.save(aluno);
     alunoRepository.save(aluno);
   
     
         
    }
    
  }
  
 
  public Aluno atualizarAluno(Aluno aluno) {
	  Aluno student = alunoRepository.getById(aluno.getId());
	  if(student != null && student.equals(aluno)) {
		  student.setCpf(aluno.getCpf());
		  student.setDataDeNascimento(aluno.getDataDeNascimento());
		  student.setId(aluno.getId());
		  student.setNome(aluno.getNome());
		  student.setStatusDaMensalidade(aluno.getStatusDaMensalidade());
	  }
	  return student;
	  
    
  }
  
  public void removerAluno(Aluno aluno) {
    Aluno alunoExistente = alunoRepository.findByNome(aluno.getNome());
    if(alunoExistente != null && alunoExistente.equals(aluno)) {
    	alunoRepository.delete(aluno);
    }
  }
  
  public void removerAluno(Long id) throws AlunoNaoExisteException {
	  Aluno alunoParaRemover = alunoRepository.getById(id);
	  
	  if(alunoParaRemover == null) {
		  throw new AlunoNaoExisteException();
	  }
	  
	  alunoRepository.delete(alunoParaRemover);
  }
  
  public Aluno buscarAluno(Aluno aluno) throws IOException {
     Aluno student = alunoRepository.getById(aluno.getId());
     if(student == null && !student.equals(aluno)) {
    	 throw new IOException("Erro!");
     }
     return student;
     
  }
  
  
  public List<Aluno> buscarAlunos(){
	  return alunoRepository.findAll();
  }
  
}
