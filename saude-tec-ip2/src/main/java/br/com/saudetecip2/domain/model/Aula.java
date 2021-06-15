package br.com.saudetecip2.domain.model;

import java.time.LocalDate;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;

public class Aula {

  private Long id;
  private LocalDate data;
  private TipoDeTreino tipoDeTreino;
  private TipoDeAula tipoDeAula;
  
  public Aula(LocalDate data, TipoDeAula tipoDeAula, TipoDeTreino tipoDeTreino){
    this.data = data;
    this.tipoDeAula = tipoDeAula;
    this.tipoDeTreino = tipoDeTreino;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public LocalDate getData() {
    return data;
  }
  public void setData(LocalDate data) {
    this.data = data;
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
