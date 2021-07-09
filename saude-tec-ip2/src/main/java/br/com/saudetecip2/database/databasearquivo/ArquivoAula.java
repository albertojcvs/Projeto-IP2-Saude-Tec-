package br.com.saudetecip2.database.databasearquivo;

import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAula {
	private String caminho;
	File arquivoTexto;

	public ArquivoAula() {
		caminho = System.getProperty("user.dir")
				+ "/src/main/java/br/com/saudetecip2/database/databasearquivo/Aula.txt";
		arquivoTexto = new File(caminho);
		System.out.println(System.getProperty("user.dir"));

	}

	public void gravarDado(Aula aula) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			gravadorDeDados.write(aula.getId() + " " + aula.getData().toString() + " " + aula.getTipoDeAula().toString()
					+ " " + aula.getTipoDeTreino().toString() + " " + aula.getProfessor());

			gravadorDeDados.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gravarDados(List<Aula> aulas) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			for(Aula aula: aulas) {
				gravadorDeDados.write(aula.getId() + " " + aula.getData().toString() + " " + aula.getTipoDeAula().toString()
						+ " " + aula.getTipoDeTreino().toString() + " " + aula.getProfessor());
			}

			gravadorDeDados.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private TipoDeTreino converterDeStringParaTipoDeTreino(String treino) {
		if (treino.equals("MUSCULACAO")) {
			return TipoDeTreino.MUSCULACAO;
		}
		if (treino.equals("AEROBICA")) {
			return TipoDeTreino.AEROBICA;
		}
		if (treino.equals("DANCA")) {
			return TipoDeTreino.DANCA;
		}
		if (treino.equals("YOGA")) {
			return TipoDeTreino.YOGA;
		}

		return TipoDeTreino.HIDROGINASTICA;

	}

	private TipoDeAula converterDeStringParaTipoDeAula(String tipoAula) {
		if (tipoAula.equals("EM_GRUPO")) {
			return TipoDeAula.EM_GRUPO;
		}
		

		return TipoDeAula.INDIVIDUAL;

	}
	public List<Aula> lerDados() {
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		try {
			FileReader fr = new FileReader(arquivoTexto);
			BufferedReader leitorDeDados = new BufferedReader(fr);
			String linha = leitorDeDados.readLine();
			
			while (linha != null) {
				String[] dados = linha.split(" ");
				Aula aula = new Aula(dados[0], LocalDateTime.parse(dados[1]), converterDeStringParaTipoDeAula(dados[2]),converterDeStringParaTipoDeTreino(dados[3]), dados[4], null);
				aulas.add(aula);
				linha = leitorDeDados.readLine();
			}
			
			leitorDeDados.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aulas;

	}
}
