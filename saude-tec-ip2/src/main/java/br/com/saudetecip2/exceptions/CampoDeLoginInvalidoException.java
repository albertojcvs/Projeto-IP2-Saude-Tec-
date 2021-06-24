package br.com.saudetecip2.exceptions;

public class CampoDeLoginInvalidoException extends Exception{
	
	public CampoDeLoginInvalidoException() {
		super("Um ou mais campos de login não são válidos!");		
	}
}
