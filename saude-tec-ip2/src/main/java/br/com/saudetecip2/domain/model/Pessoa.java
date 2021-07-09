package br.com.saudetecip2.domain.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


@MappedSuperclass
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  
  @Column(length = 55)
  @NotNull
  private String nome;
  
  @Column(length = 15)
  @NotNull
  private String cpf;
  
  @NotNull
  private LocalDate dataDeNascimento;
  
  public Pessoa(String nome, String cpf, LocalDate dataDeNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataDeNascimento = dataDeNascimento;
  }
  public Pessoa(String id, String nome, String cpf, LocalDate dataDeNascimento) {
	  this.id = id;  
	  this.nome = nome;
	    this.cpf = cpf;
	    this.dataDeNascimento = dataDeNascimento;
	  }
  public Pessoa() {}
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }
  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }
  
}
