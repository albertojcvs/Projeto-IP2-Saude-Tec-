package br.com.saudetecip2.arquivorepository;

import java.util.List;

import br.com.saudetecip2.database.Repository;
import br.com.saudetecip2.database.databasearquivo.ArquivoAluno;
import br.com.saudetecip2.domain.model.Aluno;

public class AlunoRepository implements Repository<Aluno> {

	ArquivoAluno arquivoTexto = new ArquivoAluno();

	public void deleteById(String id) {
		List<Aluno> alunos = arquivoTexto.lerDados();
		int index = 0;
		System.out.println("aaaaaaaaaa");
		for (Aluno aluno : alunos) {
			if (aluno.getId().equals(id)) {
				System.out.println("fajdlkfjsdalçjk");
				alunos.remove(index);
				break;
			}

			index++;
			continue;
		}

		arquivoTexto.gravarDados(alunos);
	}

	public List<Aluno> findAll() {
		return arquivoTexto.lerDados();
	}

	public Aluno findById(String id) {
		List<Aluno> alunos = arquivoTexto.lerDados();
		for (Aluno aluno : alunos) {
			if (aluno.getId().equals(id)) {
				return aluno;
			}
		}

		return null;
	}

	public void save(Aluno aluno) {
		List<Aluno> alunos = arquivoTexto.lerDados();

		int ultimoIndex = alunos.size() - 1;
		Aluno ultimoAlunoNoArray = ultimoIndex < 0 ? null:alunos.get(ultimoIndex);
		System.out.print(alunos.size());
		String id = alunos.size() == 0 ? String.valueOf(1): String.valueOf(Integer.valueOf(ultimoAlunoNoArray.getId()) + 1);
		aluno.setId(id);
		arquivoTexto.gravarDado(aluno);
	}

	public void update(Aluno alunoParametro) {
		List<Aluno> alunos = arquivoTexto.lerDados();
		int index = 0;
		for (Aluno aluno : alunos) {
			if (aluno.getCpf().equals(alunoParametro.getCpf())) {
				alunos.set(index, alunoParametro);
				arquivoTexto.gravarDados(alunos);
				break;
			}
			index++;
			continue;
		}

	}
	
	public Aluno findByCpf(String cpf) {
		List<Aluno> alunos = arquivoTexto.lerDados();
		for (Aluno aluno : alunos) {
			if (aluno.getCpf().equals(cpf)) {
				return aluno;
			}
		}

		return null;
	}
	
	public Aluno findByCpfAndSenha(String cpf, String senha) {
		List<Aluno> alunos = arquivoTexto.lerDados();
		for (Aluno aluno : alunos) {
			if (aluno.getCpf().equals(cpf) && aluno.getSenha().equals(senha)) {
				return aluno;
			}
		}

		return null;
	}

}
