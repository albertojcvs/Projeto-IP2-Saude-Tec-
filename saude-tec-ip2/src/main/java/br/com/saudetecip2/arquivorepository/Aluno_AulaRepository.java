package br.com.saudetecip2.arquivorepository;

import java.util.ArrayList;
import java.util.List;

import br.com.saudetecip2.database.databasearquivo.ArquivoAluno_aula;
import br.com.saudetecip2.domain.model.Funcionario;



public class Aluno_AulaRepository{
	ArquivoAluno_aula arquivoTexto = new ArquivoAluno_aula();
	public void save(String alunoId, String aulaId) {
		List<String> dados = arquivoTexto.lerDados();
		
		int ultimoIndex = dados.size() - 1;
		
		String ultimoDadoNoArray =  ultimoIndex < 0 ? null:dados.get(ultimoIndex);
		String id = dados.size() == 0? String.valueOf(1):String.valueOf(Integer.valueOf(ultimoDadoNoArray.split(" ")[0]) + 1);

		arquivoTexto.gravarDado(id, aulaId,alunoId);
		
	}
	
	public void delete(String alunoId, String aulaId) {
		List<String> dados = arquivoTexto.lerDados();
		
		int index =0;
		// Dado = "id_do_dado id_da_aula id_do_aluno "
		for(String dado:dados) {
			String[] dadosEmArray =  dado.split(" ");
			if(dadosEmArray[1].equals(aulaId) && dadosEmArray[2].equals(alunoId)) {
				dados.remove(index);
				break;
			}
			index++;
			continue;
		}
		arquivoTexto.gravarDados(dados);
		
	}
	
	public String findByAulaAndAluno(String aulaId,String alunoId) {
		List<String> dados = arquivoTexto.lerDados();
		
		for(String dado : dados) {
			String[] dadoEmArray = dado.split(" ");
			if(aulaId.equals(dadoEmArray[1]) && alunoId.equals(dadoEmArray[2])) {
				return dado;
			}
		}
		
		return null;
	}
	
	public List<String> findAllByAluno(String idAluno){
		
List<String> todosDados = arquivoTexto.lerDados();
	List<String> dadosDoAluno = new ArrayList<String>();
		for(String dado : todosDados) {
			String[] dadoEmArray = dado.split(" ");
			if( idAluno.equals(dadoEmArray[2])) {
				dadosDoAluno.add(dadoEmArray[1]);
			}
		}
		
		return dadosDoAluno;
	}
}
