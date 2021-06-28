package br.com.saudetecip2.exceptions;

import br.com.saudetecip2.domain.model.Aluno;

public class AlunoNaoEstaMarcadoNaAulaException extends Exception {
	public AlunoNaoEstaMarcadoNaAulaException(Aluno aluno){
		super("O aluno: " +aluno.getNome() +" não pode ser removido porque ele não pertence a aula!");
	}
	
	public AlunoNaoEstaMarcadoNaAulaException() {
		super("O aluno não pode ser removido porque não pertence a aula!");
	}
}
