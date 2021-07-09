package br.com.saudetecip2.views;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.utils.AulaSingleton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;

public class TelaAulasAgendadasProfessorController implements Initializable {

    @FXML
    private TableView<Aula> tabelaDeAulas;

    @FXML
    private TableColumn<Aula, Timestamp> colunaData;

    @FXML
    private TableColumn<Aula, TipoDeTreino> colunaTipoDeTreino;

    @FXML
    private TableColumn<Aula, TipoDeAula> colunaTipoDeAula;

    @FXML
    private Text textoNome;
    
    @FXML
    private TableView<Aula> tabelaDados;
   
    @FXML
    void selecionarDados(MouseEvent event) {
    	if(event.getClickCount() == 2) {
    		if(tabelaDados.getSelectionModel().getSelectedItem() != null) {
    			AulaSingleton objAula = AulaSingleton.getInstance();
    			objAula.setAula(tabelaDados.getSelectionModel().getSelectedItem()); 
    			irParaTelaAtualizarDados("TelaDeAtualizarAulasProfessor.fxml");
        		

    		}
    		
    		
    	}

    }
    
    void irParaTelaAtualizarDados(String caminho) {
		try {
			Parent telaFxml = FXMLLoader.load(getClass().getResource(caminho));
			Scene cenaTela = new Scene(telaFxml);
			Stage novaTela = new Stage();
			novaTela.setScene(cenaTela);
			tabelaDados.getScene().getRoot().setDisable(true);
			novaTela.showAndWait();
			tabelaDados.getScene().getRoot().setDisable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
   
    void irParaTela(String caminho) {
		try {
			Parent telaFxml = FXMLLoader.load(getClass().getResource(caminho));
			Scene cenaTela = new Scene(telaFxml);
			Stage novaTela = new Stage();
			novaTela.setScene(cenaTela);
			botaoSair.getScene().getRoot().setDisable(true);
			novaTela.showAndWait();
			botaoSair.getScene().getRoot().setDisable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    private Button botaoSair;


    
    @FXML
    void onBotaoSairClicked(MouseEvent event) {
    	try {
			Parent telaProfessor = FXMLLoader.load(getClass().getResource("TelaProfessorView.fxml"));
			
			botaoSair.getScene().setRoot(telaProfessor);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    	
    
}
