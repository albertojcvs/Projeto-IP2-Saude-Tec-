package br.com.saudetecip2.views;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.saudetecip2.controller.LoginAlunoController;
import br.com.saudetecip2.exceptions.CampoDeLoginInvalidoException;
import br.com.saudetecip2.exceptions.ErroLoginAlunoException;
import br.com.saudetecip2.utils.Utils;
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

import org.springframework.context.ApplicationContext;
public class TelaLoginAlunoController {

	private LoginAlunoController loginAlunoController = LoginAlunoController.getInstance();
	
	@Autowired
	private ApplicationContext springContext;
	
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

		
		String idAluno = campoIdAluno.getText();
		String senha = campoSenha.getText();

		if (idAluno.equals("") || senha.equals("")) {
			Utils.mostrarAlerta("Algum dos campos está vazio!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(senha))) {
			Utils.mostrarAlerta("O ID só aceita numéros!");
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AreaAluno.fxml"));
				loader.setControllerFactory(springContext::getBean);
				loginAlunoController.fazerLogin(new Long(idAluno), senha);
				Parent telaAluno = loader.load();
				botaoEntrar.getScene().setRoot(telaAluno);
			} catch (ErroLoginAlunoException e) {
				Utils.mostrarAlerta("O ID e/ou a senha estão incorretos!");
			} catch (Exception e) {
//				System.out.println("Erro!" + e);
				e.printStackTrace();
			}
		}

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
