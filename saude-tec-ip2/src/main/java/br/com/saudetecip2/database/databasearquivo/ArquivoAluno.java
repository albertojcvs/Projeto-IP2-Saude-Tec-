package br.com.saudetecip2.database.databasearquivo;

import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAluno {
	private String caminho;
	File arquivoTexto;

	public ArquivoAluno() {
		caminho = System.getProperty("user.dir")
				+ "/src/main/java/br/com/saudetecip2/database/databasearquivo/Aluno.txt";
		arquivoTexto = new File(caminho);
		System.out.println(System.getProperty("user.dir"));

	}

	public void gravarDado(Aluno aluno) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			gravadorDeDados.write(aluno.getId() + " " + aluno.getStatusDaMensalidade().toString() + " "
					+ aluno.getNome() + " " + aluno.getCpf() + " " + aluno.getDataDeNascimento().toString() + " "
					+ aluno.getSenha()+"\n");

			gravadorDeDados.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gravarDados(List<Aluno> alunos) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			for (Aluno aluno : alunos) {
				gravadorDeDados.write(aluno.getId() + " " + aluno.getStatusDaMensalidade().toString() + " "
						+ aluno.getNome() + " " + aluno.getCpf() + " " + aluno.getDataDeNascimento().toString()
						+ " " + aluno.getSenha()+"\n");
			}

			gravadorDeDados.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}



	private StatusDaMensalidadeDoAluno converterDeStringParaStatusDaMensalidadeDoAluno(String status) {
		if (status.equals("PAGO")) {
			return StatusDaMensalidadeDoAluno.PAGO;
		}

		return StatusDaMensalidadeDoAluno.NAO_PAGO;
	}

	public List<Aluno> lerDados() {
		System.out.println("dajsfkdj");
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		try {
			FileReader fr = new FileReader(arquivoTexto);
			BufferedReader leitorDeDados = new BufferedReader(fr);

			String linha = leitorDeDados.readLine();

			while (linha != null) {
				String[] dados = linha.split(" ");
				Aluno aluno = new Aluno(dados[0], converterDeStringParaStatusDaMensalidadeDoAluno(dados[1]), dados[2],
						dados[3], LocalDate.parse(dados[4]), dados[5]);
				alunos.add(aluno);
				linha = leitorDeDados.readLine();
			}
			leitorDeDados.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alunos;

	}
}
