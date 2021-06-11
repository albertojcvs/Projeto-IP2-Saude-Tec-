package br.com.saudetecip2.domain.model;

import java.time.LocalDate;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;

public class Aula {

  private int id;
  private LocalDate data;
  private TipoDeTreino tipoDeTreino;
  private TipoDeAula tipoDeAula;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
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
