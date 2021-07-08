package br.com.saudetecip2.views;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.Aulacontroller;
import br.com.saudetecip2.controller.LoginFuncionarioController;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.model.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class TelaAulasAgendadasProfessorController implements Initializable {

	Aulacontroller aulaController = new Aulacontroller();

	Funcionario professorLogado;

	LoginFuncionarioController loginFuncionarioController = LoginFuncionarioController.getInstace();

	@FXML
	private TableView<Aula> tabelaDeAulas;

	@FXML
	private TableColumn<Aula, Timestamp> colunaData;

	@FXML
	private TableColumn<Aula, TipoDeTreino> colunaTipoDeTreino;

	@FXML
	private TableColumn<Aula, TipoDeAula> colunaTipoDeAula;

	@FXML
	private Text textoNome;

	private void preencherTabelasDeAula() {
//    	List<Aula> aulas = aulaController.buscarAulasDoProfessor(professorLogado.getId());
//		ObservableList listaDeAulas = FXCollections.observableArrayList(aulas);
//		tabelaDeAulas.setItems(listaDeAulas);
	}

	@FXML
	void onMouseClickdedInTabelaDeAulas(MouseEvent event) {
		if (event.getClickCount() == 2) {
			if (tabelaDeAulas.getSelectionModel().getSelectedItem() != null) {

			}
		}
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
		colunaTipoDeAula.setCellValueFactory(new PropertyValueFactory<>("TipoDeAula"));
		colunaTipoDeTreino.setCellValueFactory(new PropertyValueFactory<>("TipoDeTreino"));

		preencherTabelasDeAula();

		professorLogado = loginFuncionarioController.getFuncionarioLogado();

		textoNome.setText(professorLogado.getNome());

	}

}
