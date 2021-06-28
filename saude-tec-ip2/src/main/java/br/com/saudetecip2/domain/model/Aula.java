package br.com.saudetecip2.domain.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;

@Entity
@Table(name = "aula")
public class Aula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotNull
  private Date dataAula;
  
  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoDeTreino tipoDeTreino;
  
  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoDeAula tipoDeAula;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Date getData() {
    return dataAula;
  }
  public void setData(Date dataAula) {
    this.dataAula = dataAula;
  }
  public TipoDeTreino getTipoDeTreino() {
    return tipoDeTreino;
  }
  public void setTipoDeTreino(TipoDeTreino tipoDeTreino) {
    this.tipoDeTreino = tipoDeTreino;
  }
  public TipoDeAula getTipoDeAula() {
    return tipoDeAula;
  }
  public void setTipoDeAula(TipoDeAula tipoDeAula) {
    this.tipoDeAula = tipoDeAula;
  }
}
