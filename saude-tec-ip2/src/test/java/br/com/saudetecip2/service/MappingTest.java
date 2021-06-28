package br.com.saudetecip2.service;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;

@SpringBootTest
public class MappingTest {
  
  @Autowired
  AlunoRepository alunoRepository;
  
  
  
  @Test
  public void testeInsert() {
//    Date date = Date.valueOf(LocalDate.now());
//    StatusDaMensalidadeDoAluno status = StatusDaMensalidadeDoAluno.NAO_PAGO;
//    Aluno alunoTeste = new Aluno("Pedro Moreira", "15165145122", date, status);
//    System.out.println(alunoTeste.getStatusDaMensalidade());
//    System.out.println(alunoTeste.getNome());
//    System.out.println("status: " + status);
//    alunoRepository.save(alunoTeste);
    
  }

}
