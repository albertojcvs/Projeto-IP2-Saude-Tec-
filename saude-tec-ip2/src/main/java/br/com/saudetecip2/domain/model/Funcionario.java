package br.com.saudetecip2.domain.model;

import java.time.LocalDate;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDoFuncionario;

public class Funcionario extends Pessoa{

  private int id;
  private CargoFuncionario cargo;
  private StatusDoFuncionario statusDoFuncionario;
  private double salario;
  
  public Funcionario(String nome, String cpf, LocalDate dataDeNascimento,CargoFuncionario cargoFuncionario, StatusDoFuncionario statusDosFuncionario) {
	  super(nome,cpf, dataDeNascimento);
	  
	  this.cargo = cargo;
  }
  
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public CargoFuncionario getCargo() {
    return cargo;
  }
  public void setCargo(CargoFuncionario cargo) {
    this.cargo = cargo;
  }
  public StatusDoFuncionario getStatusDoFuncionario() {
    return statusDoFuncionario;
  }
  public void setStatusDoFuncionario(StatusDoFuncionario statusDoFuncionario) {
    this.statusDoFuncionario = statusDoFuncionario;
  }
  public double getSalario() {
    return salario;
  }
  public void setSalario(double salario) {
    this.salario = salario;
  }
}
