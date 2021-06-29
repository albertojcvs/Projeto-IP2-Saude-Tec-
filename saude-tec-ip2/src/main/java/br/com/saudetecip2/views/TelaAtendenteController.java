package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.LoginFuncionarioController;
import br.com.saudetecip2.domain.model.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;


public class TelaAtendenteController implements Initializable{

	LoginFuncionarioController loginFuncionarioController = LoginFuncionarioController.getInstace();
	private Funcionario funcionarioLogado;
    @FXML
    private Button botaoAdicionarAluno;

    @FXML
    private Button botaoRemoverAluno;

    @FXML
    private Button botaoAgendarAula;

    @FXML
    private Button botaoAdicionarAlunoEmAula;

    @FXML
    private Button botaoMudarStatusMensalidade;

    @FXML
    private Text textoNomeDoFuncionario;

    @FXML
    private Button botsaoSair;

    @FXML
    void onBotaoAdicionarAlunoClicked(MouseEvent event) {

    }

    @FXML
    void onBotaoAgendarAulaClicked(MouseEvent event) {

    }

    @FXML
    void onBotaoMudarStatusMensalidadeClicked(MouseEvent event) {

    }

    @FXML
    void onBotaoRemoverAlunoClicked(MouseEvent event) {

    }

    @FXML
    void onbotaoAdiocionarAlunoEmAulaClicked(MouseEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	funcionarioLogado = loginFuncionarioController.getFuncionarioLogado();
    	textoNomeDoFuncionario.setText(funcionarioLogado.getNome());
    }

}