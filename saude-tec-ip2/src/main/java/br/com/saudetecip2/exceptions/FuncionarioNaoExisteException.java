package br.com.saudetecip2.exceptions;

public class FuncionarioNaoExisteException extends Exception{
	
	public FuncionarioNaoExisteException() {
		super("Funcionário não pode ser removido porque não existe!");
	}
}
