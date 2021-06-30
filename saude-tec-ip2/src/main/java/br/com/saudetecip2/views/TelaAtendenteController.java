package br.com.saudetecip2.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.LoginFuncionarioController;
import br.com.saudetecip2.domain.model.Funcionario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;

public class TelaAtendenteController implements Initializable {

	LoginFuncionarioController loginFuncionarioController = LoginFuncionarioController.getInstace();
	private Funcionario funcionarioLogado;
	@FXML
	private Button botaoAdicionarAluno;

	@FXML
	private Button botaoRemoverAluno;

	@FXML
	private Button botaoAbrirControleDeAula;

	@FXML
	private Button botaoMudarStatusMensalidade;

	@FXML
	private Text textoNomeDoFuncionario;

	@FXML
	private Button botsaoSair;

	@FXML
	void onAbrirControleDeAulaClicked(MouseEvent event) {
		irParaTela("TelaControleDeAula.fxml");
	}

	@FXML
	void onBotaoAdicionarAlunoClicked(MouseEvent event) {
		irParaTela("TelaAdicionarAluno.fxml");
	}

	@FXML
	void onBotaoMudarStatusMensalidadeClicked(MouseEvent event) {
		irParaTela("TelaMudarStatusDePagamento.fxml");
	}

	@FXML
	void onBotaoRemoverAlunoClicked(MouseEvent event) {
		irParaTela("TelaRemoverAluno.fxml");
	}

	@FXML
	void onBotaoSairClicked() {
		try {
			Parent telaFuncionario = FXMLLoader.load(getClass().getResource("TelaFuncionarioView.fxml"));
			
			botsaoSair.getScene().setRoot(telaFuncionario);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void irParaTela(String caminho) {
		try {
			Parent telaFxml = FXMLLoader.load(getClass().getResource(caminho));
			Scene cenaTela = new Scene(telaFxml);
			Stage novaTela = new Stage();
			novaTela.setScene(cenaTela);
			botaoAdicionarAluno.getScene().getRoot().setDisable(true);
			novaTela.showAndWait();
			botaoAdicionarAluno.getScene().getRoot().setDisable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		funcionarioLogado = loginFuncionarioController.getFuncionarioLogado();
//		textoNomeDoFuncionario.setText(funcionarioLogado.getNome());
	}

}