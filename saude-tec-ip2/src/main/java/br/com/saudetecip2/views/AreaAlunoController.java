package br.com.saudetecip2.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TableColumn<Aula, Timestamp> colunaData;

	@FXML
	private TableColumn<Aula, String> colunaProfessor;

	@FXML
	private TableColumn<Aula, String> colunaTipoDeAula;

	@FXML
	private TableColumn<Aula, String> colunaTipoDeTreino;

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
//		List<Aula> aulas = aulaController.buscarAulasDoAluno(alunoLogado.getId());
//		ObservableList lista = FXCollections.observableArrayList(aulas);
//		tabelaDeAulasAgendadas.setItems(lista);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		colunaData.setCellFactory(cell -> {
			return new TableCell<Aula, Timestamp>() {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm");

				@Override
				protected void updateItem(Timestamp item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						setText(format.format(item));
					} else {
						setText("");
						setGraphic(null);
					}
				}
			};
		});

		colunaData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		colunaProfessor.setCellValueFactory(new PropertyValueFactory<>("Professor"));
		colunaTipoDeAula.setCellValueFactory(new PropertyValueFactory<>("TipoDeAula"));
		colunaTipoDeTreino.setCellValueFactory(new PropertyValueFactory<>("TipoDeTreino"));

		alunoLogado = loginAlunoController.getAlunoLogado();
		textoNomeAluno.setText(alunoLogado.getNome());

		preencherTabelaDeAulas();
	}

}
