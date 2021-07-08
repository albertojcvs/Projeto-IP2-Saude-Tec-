package br.com.saudetecip2.views;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    	
    
}
