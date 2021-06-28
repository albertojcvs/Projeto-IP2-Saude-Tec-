package br.com.saudetecip2.views;

import br.com.saudetecip2.controller.FuncionarioController;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import br.com.saudetecip2.exceptions.FuncionarioNaoExisteException;
import br.com.saudetecip2.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaRemoverFuncionarioController {
	private FuncionarioController funcionarioController = new FuncionarioController();
	@FXML
	private TextField campoId;

	@FXML
	private Button botaoRemover;

	@FXML
	void onBotaoRemoverCklcked(MouseEvent event) {
		String id = campoId.getText();
		if (id.equals("")) {
			Utils.mostrarAlerta("O campo está vazio!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(id))) {
			Utils.mostrarAlerta("O campo só aceita números!");
		} else {
			try {
				funcionarioController.removerFuncionario(new Long(id));
			} catch (FuncionarioNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			} catch (Exception e) {
				System.out.println("Erro!");
			}
		}
	}

}
