package br.com.saudetecip2.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.LoginFuncionarioController;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.exceptions.ErroLoginFuncionarioException;
import br.com.saudetecip2.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class TelaFuncionarioController implements Initializable {

	private LoginFuncionarioController loginFuncionarioController = LoginFuncionarioController.getInstace();

	@FXML
	private Text txtTitulo;

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnVoltarParaHome;

	@FXML
	private TextField campoID;

	@FXML
	private Label lbID;

	@FXML
	private Label lbSenha;

	@FXML
	private PasswordField campoSenha;

	private void irParaTela(String caminho) {
		try {
			Parent outraTela = FXMLLoader.load(getClass().getResource(caminho));
			btnLogin.getScene().setRoot(outraTela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void irParaTelaDoFuncionario(CargoFuncionario cargo) {
		if (cargo == CargoFuncionario.ATENDENTE) {
			irParaTela("TelaAtendente.fxml");
		}
		if (cargo == CargoFuncionario.GERENTE) {
			irParaTela("TelaGerente.fxml");
		}
		if (cargo == CargoFuncionario.PROFESSOR) {
			irParaTela("TelaProfessor.fxml");
		}

	}

	@FXML
	void logar(MouseEvent event) {

		String idFuncionario = campoID.getText();
		String senha = campoSenha.getText();

		if (idFuncionario.equals("") || senha.equals("")) {
			Utils.mostrarAlerta("Algum dos campos está vazio!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(senha))) {
			Utils.mostrarAlerta("O ID só aceita números!");
		} else {
			try {
				loginFuncionarioController.fazerLogin(new Long(idFuncionario), senha);
				Funcionario funcionarioLogado = loginFuncionarioController.getFuncionarioLogado();
				irParaTelaDoFuncionario(funcionarioLogado.getCargo());
				
			} catch (ErroLoginFuncionarioException e) {
				Utils.mostrarAlerta("O ID e/ou a senha estão incorretos!");
			} catch (Exception e) {
				System.out.print("Erro!");
			}
		}
	}

	@FXML
	void voltarParaHome(MouseEvent event) {
		System.out.println("Voltar");
		try {
			Parent componente = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			btnVoltarParaHome.getScene().setRoot(componente);
		} catch (Exception e) {

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
