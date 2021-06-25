package br.com.saudetecip2.views;

import java.io.IOException;

import br.com.saudetecip2.controller.LoginAlunoController;
import br.com.saudetecip2.exceptions.CampoDeLoginInvalidoException;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class TelaLoginAlunoController {

	private LoginAlunoController loginAlunoController = LoginAlunoController.getInstance();
	@FXML
	private Button botaoVoltar;

	@FXML
	private TextField campoIdAluno;

	@FXML
	private PasswordField campoSenha;

	@FXML
	private Button botaoEntrar;

	@FXML
	void onBotaoEntrarClicked(MouseEvent event) {
		final String regexSoNumeros = "^[0-9]*$";

		String idAluno = campoIdAluno.getText();
		String senha = campoSenha.getText();

		if (idAluno.equals("") || senha.equals("")) {
			mostrarAlerta("Algum dos campos está vazio!");
		} else if (!(senha.matches(regexSoNumeros))) {
			mostrarAlerta("O ID só aceita numéros!");
		} else {
			try {
				loginAlunoController.fazerLogin(new Long(idAluno), senha);
			} catch (ErroLoginAlunoException e) {
				mostrarAlerta("O ID e/ou a senha estão incorretos!");
			}
		}

	}

	private void mostrarAlerta(String mensagem) {
		Alert alertaErro = new Alert(AlertType.NONE, mensagem, ButtonType.OK);
		alertaErro.setTitle("Erro!");
		alertaErro.showAndWait();
	}

	@FXML
	void onBotaoVoltarClicked(MouseEvent event) {
		irParaHome();
	}

	private void irParaHome() {
		try {
			Parent telaHome = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			botaoVoltar.getScene().setRoot(telaHome);
		} catch (Exception e) {
			System.out.println("Erro ao ir para a Home!");
		}
	}

}
