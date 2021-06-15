package br.com.saudetecip2.exceptions;
public class AulaJaExisteException extends Exception{
	public AulaJaExisteException() {
		super("Aula não pode ser criada por que já existe!");
	}
}