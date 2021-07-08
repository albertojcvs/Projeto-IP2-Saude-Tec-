package br.com.saudetecip2.views;

import java.sql.Date;
import java.time.LocalDate;

import br.com.saudetecip2.controller.AlunoController;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaAdicionarAlunoController {

	private AlunoController alunoController = new AlunoController();
	
	@FXML
	private TextField campoNome;

	@FXML
	private TextField campoCpf;

	@FXML
	private DatePicker campoDataNascimento;

	@FXML
	private Button botaoAdicionar;

	@FXML
	private TextField campoSenha;
	
	private void limparCampos() {
		campoNome.setText("");
		campoCpf.setText("");
		campoSenha.setText("");
		campoDataNascimento.setValue(null);
	}
	
	@FXML
    void onBotaoAdicionarClicked(MouseEvent event) {
    	String nome = campoNome.getText();
    	String cpf = campoCpf.getText();
    	String senha = campoSenha.getText();
    	Date dataNascimento = Date.valueOf(campoDataNascimento.getValue());
    	
    	if(nome.equals("") ||  senha.equals("")|| cpf.equals("")||dataNascimento == null) {
    		Utils.mostrarAlerta("Algum dos campos está vazio!");
    	}else if(!(Utils.checarSeStringContemApenasNumeros(cpf))) {
    		Utils.mostrarAlerta("Cpf só pode ter números!");
    	}else {
    		Aluno novoAluno = new Aluno(null,StatusDaMensalidadeDoAluno.PAGO,nome,cpf,dataNascimento,senha);
    		alunoController.adicionarAluno(novoAluno);
    		Utils.mostrarAlerta("Novo aluno Adicionado");
    		limparCampos();
    	}
    }
}
