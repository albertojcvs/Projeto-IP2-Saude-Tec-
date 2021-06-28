package br.com.saudetecip2.domain.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;

@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa{
  
  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(length = 8)
  private StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno;
  
  
  
  public Aluno( String nome, String cpf, Date dataDeNascimento, StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno ) {
    super(nome, cpf, dataDeNascimento);
    this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
  }
  
  
  public StatusDaMensalidadeDoAluno getStatusDaMensalidade() {
    return statusDaMensalidadeDoAluno;
  }
  public void setStatusDaMensalidade(StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno) {
    this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
  }

  
 
  
  

}
