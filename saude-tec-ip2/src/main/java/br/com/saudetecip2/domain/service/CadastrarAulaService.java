package br.com.saudetecip2.domain.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;

@Service
public class CadastrarAulaService {

  @Autowired
  Aula aulaRepository;
  
  public void cadastrarAluno(Aula aula) {

    Aula aulaExistente = aulaRepository.findByNome(aula);
    if(aulaExistente != null && !aulaExistente.equals(aula)) {
        
     alunoRepository.save(aluno);
      
    }
    
  }
  
}
