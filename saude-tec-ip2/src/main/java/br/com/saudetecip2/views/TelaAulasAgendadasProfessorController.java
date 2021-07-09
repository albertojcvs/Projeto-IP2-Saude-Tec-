package br.com.saudetecip2.views;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.Aulacontroller;
import br.com.saudetecip2.controller.LoginFuncionarioController;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aula;

import br.com.saudetecip2.utils.AulaSingleton;

import br.com.saudetecip2.domain.model.Funcionario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class TelaAulasAgendadasProfessorController implements Initializable {

	Aulacontroller aulaController = new Aulacontroller();

	Funcionario professorLogado;

	LoginFuncionarioController loginFuncionarioController = LoginFuncionarioController.getInstace();

	@FXML
	private TableView<Aula> tabelaDeAulas;

	@FXML
	private TableColumn<Aula, LocalDateTime> colunaData;

	@FXML
	private TableColumn<Aula, TipoDeTreino> colunaTipoDeTreino;

	@FXML
	private TableColumn<Aula, TipoDeAula> colunaTipoDeAula;

	private void preencherTabelasDeAula() {
    	List<Aula> aulas = aulaController.buscarAulasDeProfessor(professorLogado.getId());
		ObservableList listaDeAulas = FXCollections.observableArrayList(aulas);
		tabelaDeAulas.setItems(listaDeAulas);
	}

	@FXML
	void onMouseClickdedInTabelaDeAulas(MouseEvent event) {
		if (event.getClickCount() == 2) {
			if (tabelaDeAulas.getSelectionModel().getSelectedItem() != null) {

			}
		}
	}


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

		colunaData.setCellFactory(cell -> {
			return new TableCell<Aula, LocalDateTime>() {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

				@Override
				protected void updateItem(LocalDateTime item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						setText(format.format(item));
					} else {
						setText("");
						setGraphic(null);
					}
				}
			};
		});

		colunaData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		colunaTipoDeAula.setCellValueFactory(new PropertyValueFactory<>("TipoDeAula"));
		colunaTipoDeTreino.setCellValueFactory(new PropertyValueFactory<>("TipoDeTreino"));

		professorLogado = loginFuncionarioController.getFuncionarioLogado();

		preencherTabelasDeAula();


		textoNome.setText(professorLogado.getNome());


	}

}
