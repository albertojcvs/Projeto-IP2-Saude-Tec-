package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.AlunoController;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import br.com.saudetecip2.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;

public class TelaMudarStatusDePagamentoController {

	AlunoController alunoController = new AlunoController();
	
	@FXML
	private Button botaoMudarStatusDePagamento;

	@FXML
	private TextField campoCpf;

	@FXML
	private RadioButton opcaoPago;

	@FXML
	private ToggleGroup opcoes;

	@FXML
	private RadioButton opcaoNaoPago;

	private void limparCampos() {
		campoCpf.setText("");
		opcaoPago.setSelected(true);
	}

	@FXML
	void onBotaoMudarStatusPagamentoClicked(MouseEvent event) {
		String cpfAluno = campoCpf.getText();
		StatusDaMensalidadeDoAluno status = opcaoPago.isSelected() ? StatusDaMensalidadeDoAluno.PAGO
				: StatusDaMensalidadeDoAluno.NAO_PAGO;

		if (cpfAluno.equals("")) {
			Utils.mostrarAlerta("O campo não pode ser vazio!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(cpfAluno))) {
			Utils.mostrarAlerta("O campo só deve conter números!");
		} else {
			try {
				alunoController.mudarStatusDaMensalidadeDoAluno(cpfAluno, status);
				Utils.mostrarAlerta("Status foi alterado com sucesso!");
				limparCampos();
			} catch (AlunoNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}
	}
}
