package br.com.saudetecip2.domain.model;

import java.time.LocalDate;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDoFuncionario;

public class Funcionario extends Pessoa {

  private Long id;
  private CargoFuncionario cargo;
  private StatusDoFuncionario statusDoFuncionario;
  private double salario;
  private String senha;
  
  public Funcionario(String nome, String cpf, LocalDate dataDeNascimento,
		 CargoFuncionario cargo, StatusDoFuncionario status, double salario,String senha) {
	  super(nome,cpf,dataDeNascimento);
	  this.senha = senha;
	  this.cargo = cargo;
	  this.statusDoFuncionario = status;
	  this.salario = salario;
  }
  
  public String getSenha() {
	return senha;
}
  public void setSenha(String senha) {
	this.senha = senha;
}
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
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
  
  @Override
	public boolean equals(Object obj) {
		if(obj instanceof Funcionario) {
			Funcionario funcionarioParametroDado = (Funcionario) obj;
			
			if(funcionarioParametroDado.getId() == this.id) {
				return true;
			}
		}
		return false;
	}
}
