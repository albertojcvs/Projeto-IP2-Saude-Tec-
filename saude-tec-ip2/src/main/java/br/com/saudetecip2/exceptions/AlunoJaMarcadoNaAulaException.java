package br.com.saudetecip2.exceptions;

public class AlunoJaMarcadoNaAulaException extends Exception{
	public AlunoJaMarcadoNaAulaException() {
		super("O aluno já estar marcado na aula!");
	}
}
