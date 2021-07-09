package br.com.saudetecip2.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.saudetecip2.controller.LoginAlunoController;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.repository.AlunoRepository;
import br.com.saudetecip2.domain.service.FazerLoginAlunoService;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;

@SpringBootTest
class TesteServicoLogin {
	@Autowired
	FazerLoginAlunoService fazerLoginService;
	
	@Autowired
	AlunoRepository aluno;
	
	@Autowired
	LoginAlunoController loginAluno = LoginAlunoController.getInstance();
	
	@Test
	void test() {
		
		Aluno a = new Aluno();
		
		Long id = new Long(2);
		String senha = "123";
		try {
			a = this.fazerLoginService.fazerLogin("", senha);
			System.out.print(a.getNome());
		} catch (Exception e) {
		}
	}
	@Test
	void testar() {
		Optional<Aluno>  a = aluno.findById(new Long(2));
		System.out.println(a.get().getNome());
	}
	
	@Test
	void testarLoginAlunoController() {
		try {
			loginAluno.fazerLogin("", "123");
		} catch (ErroLoginAlunoException e) {
			e.printStackTrace();
		}
	}

}
