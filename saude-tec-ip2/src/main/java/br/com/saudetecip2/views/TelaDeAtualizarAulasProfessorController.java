package br.com.saudetecip2.views;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Observable;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.Aulacontroller;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;
import br.com.saudetecip2.utils.AulaSingleton;
import br.com.saudetecip2.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class TelaDeAtualizarAulasProfessorController implements Initializable {

	AulaSingleton objAula = AulaSingleton.getInstance();
	Aulacontroller aulaController = new Aulacontroller();

	@FXML
	private Text txtTitulo;

	@FXML
	private Label lbData;

	@FXML
	private Label lbHorario;

	@FXML
	private Label lbTreino;

	@FXML
	private Label lbTipo;

	@FXML
	private DatePicker calendario;

	@FXML
	private TextField campoHora;

	@FXML
	private TextField campoMinutos;

	@FXML
	private ChoiceBox<TipoDeTreino> campoTreino;

	@FXML
	private ChoiceBox<TipoDeAula> campoTipo;

	@FXML
	private Button btnAtualizar;

	@FXML
	private Button btnDeletar;

	@FXML
	void atualizarDados(MouseEvent event) {

		TipoDeTreino tipoDeTreino = campoTreino.getValue();
		TipoDeAula tipoAula = campoTipo.getValue();
		String hora = campoHora.getText();
		String minutos = campoMinutos.getText();
		LocalDate data = calendario.getValue();

		if (hora.equals("") || minutos.equals("") || data == null) {
			Utils.mostrarAlerta("Todos os campos devem ser preenchidos");
		} else if (!(Utils.checarSeStringContemApenasNumeros(hora)
				|| !(Utils.checarSeStringContemApenasNumeros(minutos)))) {
			Utils.mostrarAlerta("Os campos de hora e minutos devem conter apenas números");
		} else {
			try {
				System.out.println(tipoDeTreino);
				Aula aulaParaAtualizar = objAula.getAula();
				Aula aulaAtualizada = new Aula(aulaParaAtualizar.getId(),LocalDateTime.of(data, LocalTime.of(Integer.valueOf(hora), Integer.valueOf(minutos))),
						tipoAula, tipoDeTreino, aulaParaAtualizar.getProfessor(), null);
				aulaController.atualizarAula(aulaAtualizada);
				Utils.mostrarAlerta("Aula atualizada com sucesso!");
				objAula.setAula(aulaAtualizada);
				carregarDadosDeAula();
			} catch (AulaNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}

	}

	@FXML
	void deletarDado(MouseEvent event) {
		try {
			Alert alerta = new Alert(AlertType.CONFIRMATION,"Cofirmar para deletar essa aula"); 
			alerta.showAndWait();
			ButtonType botaoClicado = alerta.getResult();
			if(botaoClicado == ButtonType.OK) {
				aulaController.deletarAula(objAula.getAula().getId());
				Stage tela = (Stage) btnDeletar.getScene().getWindow();
				objAula.setAula(null);
				tela.close();
			}
		} catch (AulaNaoExisteException e) {
			Utils.mostrarAlerta(e.getMessage());

		}
	}
	
	private void carregarDadosDeAula() {
		campoTreino.setValue(objAula.getAula().getTipoDeTreino());
		campoTipo.setValue(objAula.getAula().getTipoDeAula());
		campoHora.setText(String.valueOf(objAula.getAula().getData().getHour()));
		calendario.setValue(LocalDate.of(objAula.getAula().getData().getYear(), objAula.getAula().getData().getMonth(),
				objAula.getAula().getData().getDayOfMonth()));
		campoMinutos.setText(String.valueOf(objAula.getAula().getData().getMinute()));
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList listaDeTreinos = FXCollections.observableArrayList(TipoDeTreino.values());
		ObservableList listaDeTipoDeAula = FXCollections.observableArrayList(TipoDeAula.values());
		
		
		campoTreino.setItems(listaDeTreinos);
		campoTipo.setItems(listaDeTipoDeAula);
		carregarDadosDeAula();
	}

}
