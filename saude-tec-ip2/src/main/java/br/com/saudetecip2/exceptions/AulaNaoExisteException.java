package br.com.saudetecip2.exceptions;

public class AulaNaoExisteException extends Exception {

	public AulaNaoExisteException() {
		super("Aula não pode ser removida por que não existe!");
	}

}
