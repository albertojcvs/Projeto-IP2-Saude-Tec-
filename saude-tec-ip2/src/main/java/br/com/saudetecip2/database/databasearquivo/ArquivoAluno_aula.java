package br.com.saudetecip2.database.databasearquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAluno_aula {
	private String caminho;
	File arquivoTexto;

	public ArquivoAluno_aula() {
		caminho = System.getProperty("user.dir")
				+ "/src/main/java/br/com/saudetecip2/database/databasearquivo/Alunos-Aula.txt";
		arquivoTexto = new File(caminho);

	}



	public void gravarDado(String id,String aulaId, String alunoId) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			gravadorDeDados.write(id + " " + aulaId + " " + alunoId +"\n" );
			gravadorDeDados.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void gravarDados(List<String> dados) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			for(String dado: dados) {
				String[] dadoEmArray = dado.split(" ");
				gravadorDeDados.write(dadoEmArray[0] + " " + dadoEmArray[1]+ " " + dadoEmArray[2]+"\n" );
			}
			gravadorDeDados.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> lerDados() {
		ArrayList<String> dados = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(arquivoTexto);
			BufferedReader leitorDeDados = new BufferedReader(fr);

			String linha = leitorDeDados.readLine();

			while (linha != null) {
				dados.add(linha);
				
				linha = leitorDeDados.readLine();
			}
			leitorDeDados.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dados;

	}
}
