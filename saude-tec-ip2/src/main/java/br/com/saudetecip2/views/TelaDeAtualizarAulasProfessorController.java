package br.com.saudetecip2.views;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.utils.AulaSingleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class TelaDeAtualizarAulasProfessorController implements Initializable{
	
	AulaSingleton objAula = AulaSingleton.getInstance();

	
	 @FXML
	    private Text txtTitulo;
	 
	    @FXML
	    private Label lbData;

	    @FXML
	    private Label lbHorario;

	    @FXML
	    private Label lbTreino;

	    @FXML
	    private Label lbTipo;

	    @FXML
	    private DatePicker calendario;

	    @FXML
	    private TextField campoHora;

	    @FXML
	    private TextField campoMinutos;

	    @FXML
	    private ChoiceBox<TipoDeTreino> campoTreino;

	    @FXML
	    private ChoiceBox<TipoDeAula> campoTipo;
	    
	    @FXML
	    private Button btnAtualizar;

	    @FXML
	    private Button btnDeletar;

	    @FXML
	    void atualizarDados(MouseEvent event) {
	    	

	    }

	    @FXML
	    void deletarDado(MouseEvent event) {

	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Aula aulaExemplo = new Aula(Timestamp.valueOf(LocalDateTime.now()), TipoDeAula.INDIVIDUAL, TipoDeTreino.MUSCULACAO, new Long(2) , null  );
		objAula.setAula(aulaExemplo);
		
		
		ObservableList<TipoDeTreino> listaTreinos = FXCollections.observableArrayList(TipoDeTreino.values());
		ObservableList<TipoDeAula> listaAulas = FXCollections.observableArrayList(TipoDeAula.values());

		campoTreino.setItems(listaTreinos);
		campoTipo.setItems(listaAulas);
		campoTreino.setValue(objAula.getAula().getTipoDeTreino());
    	campoTipo.setValue(objAula.getAula().getTipoDeAula());
    	campoHora.setText(String.valueOf(objAula.getAula().getData().toLocalDateTime().getHour()));
    	calendario.setValue(LocalDate.of(objAula.getAula().getData().toLocalDateTime().getYear(),objAula.getAula().getData().toLocalDateTime().getMonth(),objAula.getAula().getData().toLocalDateTime().getDayOfMonth()));
    	campoMinutos.setText(String.valueOf(objAula.getAula().getData().toLocalDateTime().getMinute()));

    	
    	
	}

}
