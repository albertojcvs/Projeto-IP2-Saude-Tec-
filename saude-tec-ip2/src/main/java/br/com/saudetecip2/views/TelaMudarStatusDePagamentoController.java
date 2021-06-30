package br.com.saudetecip2.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;


public class TelaMudarStatusDePagamentoController {

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

    
    @FXML
    void onBotaoMudarStatusPagamentoClicked(MouseEvent event) {

    }
}
