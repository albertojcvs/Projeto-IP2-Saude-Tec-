package br.com.saudetecip2.domain.model;

import java.time.LocalDate;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;

public class Aluno extends Pessoa{
  
  private Long id;
 
  private StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno;
  
  public Aluno(Long id, StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno, String nome, String cpf, LocalDate dataDeNascimento) {
    super(nome, cpf, dataDeNascimento);
    
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public StatusDaMensalidadeDoAluno getStatusDaMensalidade() {
    return statusDaMensalidadeDoAluno;
  }
  public void setStatusDaMensalidade(StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno) {
    this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
  }

  
 
  
  

}
