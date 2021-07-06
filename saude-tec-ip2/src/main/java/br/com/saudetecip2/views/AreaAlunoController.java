package br.com.saudetecip2.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import br.com.saudetecip2.controller.Aulacontroller;
import br.com.saudetecip2.controller.LoginAlunoController;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.model.Aula;

public class AreaAlunoController implements Initializable {
	private Aluno alunoLogado;
	LoginAlunoController loginAlunoController = LoginAlunoController.getInstance();

	Aulacontroller aulaController = new Aulacontroller();
	@FXML
	private Text textoNomeAluno;

	@FXML
	private Text textoIDAluno;

	@FXML
	private TableView<Aula> tabelaDeAulasAgendadas;

	@FXML
	private Button botaoSair;

	@FXML
	private TableColumn<Aula, Date> colunaData;

	@FXML
	private TableColumn<Aula, String> colunaProfessor;

	@FXML
	private TableColumn<Aula, TipoDeAula> colunaTipoDeAula;

	@FXML
	private TableColumn<Aula, TipoDeTreino> colunaTipoDeTreino;

	public Aluno getAlunoLogado() {
		return alunoLogado;
	}

	public void setAlunoLogado(Aluno alunoLogado) {
		this.alunoLogado = alunoLogado;
	}

	@FXML
	public void onBotaoSairClicked() {
		loginAlunoController.fazerLogout();
		Parent novaTela;
		try {
			novaTela = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			botaoSair.getScene().setRoot(novaTela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void preencherTabelaDeAulas() {
		List<Aula> aulas = aulaController.buscarAulaDe(alunoLogado.getId());
		ObservableList lista = FXCollections.observableArrayList(aulas);
		tabelaDeAulasAgendadas.setItems(lista);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		alunoLogado = loginAlunoController.getAlunoLogado();
		textoNomeAluno.setText(alunoLogado.getNome());
		preencherTabelaDeAulas();
	}

}
