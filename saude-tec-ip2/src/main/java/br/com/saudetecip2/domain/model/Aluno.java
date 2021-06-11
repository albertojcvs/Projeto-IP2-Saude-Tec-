package br.com.saudetecip2.domain.model;

import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;

public class Aluno {
  
  private Long id;
  private StatusDaMensalidadeDoAluno statusDaMensalidade;
  private Pessoa pessoa;
  
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public StatusDaMensalidadeDoAluno getStatusDaMensalidade() {
    return statusDaMensalidade;
  }
  public void setStatusDaMensalidade(StatusDaMensalidadeDoAluno statusDaMensalidade) {
    this.statusDaMensalidade = statusDaMensalidade;
  }
  public Pessoa getPessoa() {
    return pessoa;
  }
  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
    result = prime * result + ((statusDaMensalidade == null) ? 0 : statusDaMensalidade.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Aluno other = (Aluno) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (pessoa == null) {
      if (other.pessoa != null)
        return false;
    } else if (!pessoa.equals(other.pessoa))
      return false;
    if (statusDaMensalidade != other.statusDaMensalidade)
      return false;
    return true;
  }
  

}
