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
				+ "/src/main/java/br/com/saudetecip2/database/databasearquivo/Aluno-Aula.txt";
		arquivoTexto = new File(caminho);

	}



	public void gravarDado(String aulaId, String aluno_id) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			gravadorDeDados.write("\n");

			gravadorDeDados.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gravarDados() {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);

//			for (Funcionario funcionario : funcionarios) {
//				gravadorDeDados.write(funcionario.getId() + " " + funcionario.getNome() + " " + funcionario.getCpf()
//						+ " " + funcionario.getDataDeNascimento().toString() + " " + funcionario.getCargo().toString()
//						+ " " + String.valueOf(funcionario.getSalario()) + " " + funcionario.getSenha() + "\n");
//			}

			gravadorDeDados.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> lerDados() {
		ArrayList<String> funcionarios = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(arquivoTexto);
			BufferedReader leitorDeDados = new BufferedReader(fr);

			String linha = leitorDeDados.readLine();

			while (linha != null) {
				String[] dados = linha.split(" ");
				
				linha = leitorDeDados.readLine();
			}
			leitorDeDados.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return funcionarios;

	}
}
