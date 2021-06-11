package br.com.saudetecip2.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.saudetecip2.domain.repository.AulaRepository;

@Service
public class CadastrarAulaService {
	@Autowired
	AulaRepository aulaRepository;
	
	public void cadastrarAula(Aula aula) {
		
	}
}
