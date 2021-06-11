package br.com.saudetecip2.domain.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;

@Service
public class CadastrarAlunoService {

  @Autowired
  AlunoRepository alunoRepository;
  
  public void cadastrarAluno(Aluno aluno) {

    Aluno alunoExistente = alunoRepository.findByNome(aluno.getNome());
    if(alunoExistente != null && !alunoExistente.equals(aluno)) {
        
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
  
  public Aluno buscarAluno(Aluno aluno) throws IOException {
     Aluno student = alunoRepository.getById(aluno.getId());
     if(student == null && !student.equals(aluno)) {
    	 throw new IOException("Erro!");
     }
     return student;
     
  }
  
}
