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
	private double salario;

	@NotNull
	@Column(length = 20)
	private String senha;

	public Funcionario(String nome, String cpf, LocalDate dataDeNascimento, CargoFuncionario cargo,
			 double salario, String senha) {
		super(nome, cpf, dataDeNascimento);
		this.senha = senha;
		this.cargo = cargo;
		
		this.salario = salario;
	}

	public Funcionario(String id, String nome, String cpf, LocalDate dataDeNascimento, CargoFuncionario cargo, double salario, String senha) {
		super(id, nome, cpf, dataDeNascimento);
		this.senha = senha;
		this.cargo = cargo;
		
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CargoFuncionario getCargo() {
		return cargo;
	}

	public void setCargo(CargoFuncionario cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
