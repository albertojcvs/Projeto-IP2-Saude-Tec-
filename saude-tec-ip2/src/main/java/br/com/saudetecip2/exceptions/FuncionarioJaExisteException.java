package br.com.saudetecip2.exceptions;

public class FuncionarioJaExisteException extends Exception{
	
	public FuncionarioJaExisteException() {
		super("Funcionario não pode ser cadastrado porque já existe!");
	}
}
