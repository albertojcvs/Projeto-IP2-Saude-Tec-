package br.com.saudetecip2.arquivorepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.saudetecip2.database.Repository;
import br.com.saudetecip2.database.databasearquivo.ArquivoAula;
import br.com.saudetecip2.domain.model.Aula;

public class AulaRepository implements Repository<Aula> {

	ArquivoAula arquivoTexto = new ArquivoAula();

	public void deleteById(String id) {
		List<Aula> aulas = arquivoTexto.lerDados();
		int index = 0;
		for (Aula aula: aulas) {
			if (aula.getId().equals(id)) {
				aulas.remove(index);
				break;
			}
			
			index++;
			continue;
		}
		arquivoTexto.gravarDados(aulas);
	}

	public List<Aula> findAll() {
		return arquivoTexto.lerDados();
	}

	public Aula findById(String id) {
		List<Aula> aulas= arquivoTexto.lerDados();
		for (Aula aula : aulas) {
			if (aula.getId().equals(id)) {
				return aula;
			}
		}

		return null;
	}

	public void save(Aula Aula) {
		List<Aula> aulas = arquivoTexto.lerDados();

		int ultimoIndex = aulas.size() - 1;
		Aula ultimoAulaNoArray = ultimoIndex < 0 ? null:aulas.get(ultimoIndex);
		String id =  aulas.size() == 0 ? String.valueOf(1):String.valueOf(Integer.valueOf(ultimoAulaNoArray.getId()) + 1);
		Aula.setId(id);
		arquivoTexto.gravarDado(Aula);
	}

	public void update(Aula aulaParametro) {
		List<Aula> aulas = arquivoTexto.lerDados();
		int index = 0;
		System.out.println(aulaParametro.getTipoDeTreino());
		for (Aula aula : aulas) {
			if (aula.getId().equals(aulaParametro.getId())) {
				System.out.println("to zquai");
				System.out.println(index+" ||"+aulaParametro.getId());
				aulas.set(index, aulaParametro);
				System.out.println(aulas.get(index).getTipoDeTreino());
				break;
			}
			index++;
			continue;
		}

		arquivoTexto.gravarDados(aulas);
	}
	
	public Aula findByDataAndProfessor(LocalDateTime data, String professorId) {
		
		List<Aula> aulas= arquivoTexto.lerDados();
		for (Aula aula : aulas) {
			if (aula.getData().compareTo(data) == 0 && aula.getProfessor().equals(professorId)) {
				return aula;
			}
		}
		return null;
	}
	public List<Aula> findAllByProfessor(String idProfessor){
		List<Aula> aulas = arquivoTexto.lerDados();
		
		ArrayList<Aula> aulasDoProfessor = new ArrayList<Aula>();
		for(Aula aula: aulas) {
			if(aula.getProfessor().equals(idProfessor)) {
				aulasDoProfessor.add(aula);
			}
		}
		return aulasDoProfessor;
	}
	
	
}
