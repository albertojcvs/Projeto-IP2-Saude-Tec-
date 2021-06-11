package br.com.saudetecip2.domain.model;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDoFuncionario;

public class Funcionario {

  private int id;
  private CargoFuncionario cargo;
  private StatusDoFuncionario statusDoFuncionario;
  private double salario;
  
  
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
