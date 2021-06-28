package br.com.saudetecip2.domain.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDoFuncionario;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

  @NotNull
  @Column(length = 11)
  @Enumerated(EnumType.STRING)
  private CargoFuncionario cargo;
  
  @NotNull
  @Column(length = 14)
  @Enumerated(EnumType.STRING)
  private StatusDoFuncionario statusDoFuncionario;
  
  @NotNull
  private double salario;
  
  public Funcionario(String nome, String cpf, Date dataDeNascimento,
		 CargoFuncionario cargo, StatusDoFuncionario status, double salario) {
	  super(nome,cpf,dataDeNascimento);
	  
	  this.cargo = cargo;
	  this.statusDoFuncionario = status;
	  this.salario = salario;
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
  
