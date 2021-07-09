package br.com.saudetecip2.utils;

import br.com.saudetecip2.domain.model.Aula;

public class AulaSingleton {
	
	private static AulaSingleton instance;  
	private Aula aula = null;
	
	private AulaSingleton() {
		
	}
	
	public static AulaSingleton getInstance() {
		if(instance == null) {
			instance = new AulaSingleton();
		}
		return instance;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	
	
	
	

}
