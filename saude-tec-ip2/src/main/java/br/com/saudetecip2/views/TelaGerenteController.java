package br.com.saudetecip2.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.FuncionarioController;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.StatusDoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.exceptions.FuncionarioJaExisteException;
import br.com.saudetecip2.utils.Utils;
import javafx.fxml.Initializable;

public class TelaGerenteController implements Initializable {

	ObservableList<String> cargos = FXCollections.observableArrayList("Professor", "Gerente", "Atendente",
			"OutroCargo");

	private FuncionarioController funcionarioController = new FuncionarioController();

	@FXML
	private Text txtTitulo;

	@FXML
	private Label lbCadastrarFuncionario;

	@FXML
	private Label lbNome;

	@FXML
	private Label lbCPF;

	@FXML
	private Label lbNascimento;

	@FXML
	private Label lbCargo;

	@FXML
	private TextField campoNome;

	@FXML
	private TextField campoCPF;

	@FXML
	private TextField campoSenha;

	@FXML
	private TextField campoSalario;

	@FXML
	private DatePicker campoDataNasc;

	@FXML
	private ChoiceBox<String> campoCargo;

	@FXML
	private Button btCadastrarFuncionario;

	@FXML
	private Button btnDemitir;


	@FXML
	private Button btnMatricularAluno;

	@FXML
	private Button btnRemoverAluno;

	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnControleDeAula;
	
	   @FXML
	    void controlarAula(MouseEvent event) {
		   irParaTela("TelaControleDeAula.fxml");
	    }



	@FXML
	void voltarParaTelaFuncionario(MouseEvent event) {
		try {
			Parent componente = FXMLLoader.load(getClass().getResource("TelaFuncionarioView.fxml"));
			btnVoltar.getScene().setRoot(componente);
		} catch (Exception e) {

		}

	}

	void irParaTela(String caminho) {
		try {
			Parent telaFxml = FXMLLoader.load(getClass().getResource(caminho));
			Scene cenaTela = new Scene(telaFxml);
			Stage novaTela = new Stage();
			novaTela.setScene(cenaTela);
			txtTitulo.getScene().getRoot().setDisable(true);
			novaTela.showAndWait();
			txtTitulo.getScene().getRoot().setDisable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@FXML
	void demitirFuncionario(MouseEvent event) {
		irParaTela("TelaRemoverFuncionario.fxml");
	}

	@FXML
	void matricularAluno(MouseEvent event) {
		irParaTela("TelaAdicionarAluno.fxml");
	}

	@FXML
	void removerAluno(MouseEvent event) {
		irParaTela("TelaRemoverAluno.fxml");
	}



	private CargoFuncionario converterDeStringParaCargoFuncionario(String cargoString) {
		if (cargoString == "Gerente") {
			return CargoFuncionario.GERENTE;
		}
		if (cargoString == "Professor") {
			return CargoFuncionario.PROFESSOR;
		}
		if (cargoString == "Atendente") {
			return CargoFuncionario.ATENDENTE;
		}
		return CargoFuncionario.OUTRO_CARGO;

	}

	private void limparCamposDeCasdatroDeFuncionario() {
		campoNome.setText("");
		campoSenha.setText("");
		campoSalario.setText("");
		campoCPF.setText("");
		campoDataNasc.setValue(null);
		campoCargo.setValue("Professor");
	}

	@FXML
	void cadastrarFuncionario(MouseEvent event) {
		String nome = campoNome.getText();
		String cpf = campoCPF.getText();
		Date dataNascimento = Date.valueOf(campoDataNasc.getValue()) ;
		CargoFuncionario cargo = converterDeStringParaCargoFuncionario(campoCargo.getValue());
		String senha = campoSenha.getText();
		String salario = campoSalario.getText();

		if (nome.equals("") || cpf.equals("") || dataNascimento == null || senha.equals("") || salario.equals("")) {
			Utils.mostrarAlerta("Algum dos campos está vazio!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(cpf))
				|| !(Utils.checarSeStringContemApenasNumeros(campoSalario.getText()))) {
			Utils.mostrarAlerta("Apenas numeros são aceitos nos campo de CPF e senha!");
		} else {
			try {
				Funcionario novoFuncionario = new Funcionario(nome, cpf, dataNascimento, cargo,
						StatusDoFuncionario.CONTRATADO, Double.parseDouble(salario), senha);

				funcionarioController.cadastrarFuncionario(novoFuncionario);
				limparCamposDeCasdatroDeFuncionario();

			} catch (FuncionarioJaExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoCargo.setValue("Professor");
		campoCargo.setItems(cargos);
	}

}
