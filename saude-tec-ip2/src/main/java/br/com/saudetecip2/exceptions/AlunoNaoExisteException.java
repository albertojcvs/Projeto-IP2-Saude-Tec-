package br.com.saudetecip2.exceptions;

public class AlunoNaoExisteException extends  Exception{
	public AlunoNaoExisteException() {
		super("Não é possivel remover o aluno porque ele não existe!");
	}
}
