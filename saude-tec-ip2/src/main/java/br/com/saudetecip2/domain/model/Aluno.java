package br.com.saudetecip2.domain.model;

import java.time.LocalDate;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;

public class Aluno extends Pessoa{
  
  private Long id;
 
  private StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno;
  
  private String senha;
  public Aluno(Long id, StatusDaMensalidadeDoAluno statusDaMensalidadeDoAluno, String nome, String cpf, LocalDate dataDeNascimento,String senha) {
    super(nome, cpf, dataDeNascimento);
    this.senha = senha;
    this.statusDaMensalidadeDoAluno = statusDaMensalidadeDoAluno;
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

  public String getSenha() {
	return senha;
}
  public void setSenha(String senha) {
	this.senha = senha;
}
  
 @Override
	public boolean equals(Object obj) {
	 	if(obj instanceof Aluno) {
	 		Aluno alunoParametro = (Aluno) obj;
	 		
	 		return alunoParametro.getCpf() == this.getCpf();
	 	}
	 	return false;
 }
  
  

}
