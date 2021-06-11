package br.com.saudetecip2.domain.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;

@Service
public class CadastrarAlunoService {

  @Autowired
  AlunoRepository alunoRepository;
  
  public void cadastrarAluno(Aluno aluno) {

    Aluno alunoExistente = alunoRepository.findByNome(aluno.getPessoa().getNome());
    if(alunoExistente != null && !alunoExistente.equals(aluno)  ) {
        
     alunoRepository.save(aluno);
      
      
    }
    
  }
  
  
  
  public void atualizarAluno(Aluno aluno) {
    
    
    
  }
  
  public void removerAluno(Aluno aluno) {
    
   
  }
  
  public void buscarAluno() {
    
  }
  
}
