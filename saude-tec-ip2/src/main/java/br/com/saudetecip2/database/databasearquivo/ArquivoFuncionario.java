package br.com.saudetecip2.database.databasearquivo;

import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Funcionario;

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivoFuncionario {

	private String caminho;
	File arquivoTexto;

	public ArquivoFuncionario() {
		caminho = System.getProperty("user.dir")
				+ "/src/main/java/br/com/saudetecip2/database/databasearquivo/Funcionario.txt";
		arquivoTexto = new File(caminho);

	}

	private CargoFuncionario converterDeStringParaCargoFuncionario(String cargoString) {
		if (cargoString.equals("GERENTE")) {
			return CargoFuncionario.GERENTE;
		}
		if (cargoString.equals( "PROFESSOR")) {
			return CargoFuncionario.PROFESSOR;
		}
		if (cargoString.equals("ATENDENTE")) {
			return CargoFuncionario.ATENDENTE;
		}
		return CargoFuncionario.OUTRO_CARGO;

	}

	public void gravarDado(Funcionario funcionario) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);
			gravadorDeDados.write(funcionario.getId() + " " + funcionario.getNome() + " " + funcionario.getCpf() + " "
					+ funcionario.getDataDeNascimento().toString() + " " + funcionario.getCargo().toString() + " "
					+ String.valueOf(funcionario.getSalario()) + " " + funcionario.getSenha() + "\n");

			gravadorDeDados.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gravarDados(List<Funcionario> funcionarios) {
		try {
			FileWriter fw;
			fw = new FileWriter(arquivoTexto, true);
			BufferedWriter gravadorDeDados = new BufferedWriter(fw);

			for (Funcionario funcionario : funcionarios) {
				gravadorDeDados.write(funcionario.getId() + " " + funcionario.getNome() + " " + funcionario.getCpf()
						+ " " + funcionario.getDataDeNascimento().toString() + " " + funcionario.getCargo().toString()
						+ " " + String.valueOf(funcionario.getSalario()) + " " + funcionario.getSenha() + "\n");
			}

			gravadorDeDados.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> lerDados() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			FileReader fr = new FileReader(arquivoTexto);
			BufferedReader leitorDeDados = new BufferedReader(fr);

			String linha = leitorDeDados.readLine();

			while (linha != null) {
				String[] dados = linha.split(" ");
				Funcionario funcionario = new Funcionario(dados[0], dados[1], dados[2], LocalDate.parse(dados[3]),
						converterDeStringParaCargoFuncionario(dados[4]), Double.valueOf(dados[5]), dados[6]);
				funcionarios.add(funcionario);
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
