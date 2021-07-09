package br.com.saudetecip2.views;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Observable;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.AlunoController;
import br.com.saudetecip2.controller.Aulacontroller;
import br.com.saudetecip2.controller.LoginFuncionarioController;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.exceptions.AlunoJaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoEstaMarcadoNaAulaException;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;
import br.com.saudetecip2.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;

public class TelaProfessorController implements Initializable {

	ObservableList<TipoDeTreino> treinos = FXCollections.observableArrayList(TipoDeTreino.values());

	LoginFuncionarioController loginFuncionarioController = LoginFuncionarioController.getInstace();
	Aulacontroller aulaController = new Aulacontroller();
	Funcionario funcionarioLogado = null;
	AlunoController alunoController = new AlunoController();

	@FXML
	private Text txtTitulo;

	@FXML
	private Text textoNome;

	@FXML
	private Button btnVerAulasAgendadas;

	@FXML
	private Button botaoSair;

	@FXML
	private Tab opAgendarAula;

	@FXML
	private Label lbData;

	@FXML
	private ChoiceBox<TipoDeTreino> campoTreino;

	@FXML
	private Label lbTreino;

	@FXML
	private DatePicker campoDataAgendarAula;

	@FXML
	private Button btnAgendarAula;

	@FXML
	private Tab opRemoverAula;

	@FXML
	private Label lbIDRemoverAula;

	@FXML
	private TextField campoRemoverAula;

	@FXML
	private Button btnRemoverAula;

	@FXML
	private Tab opAddAlunoNaAula;

	@FXML
	private Label lbIDAluno;

	@FXML
	private Label lbIDAula;

	@FXML
	private TextField campoCpfAlunoAdicionar;

	@FXML
	private TextField campoIDAulaAdicionar;

	@FXML
	private TextField campoCpfAlunoRemover;

	@FXML
	private TextField campoIDAulaRemover;

	@FXML
	private Button btnAdicionarAlunoNaAula;

	@FXML
	private Tab opRemoverAlunoDaAula;

	@FXML
	private Button btnRemoverAlunoDaAula;

	@FXML
	private ChoiceBox<TipoDeAula> campoTipoAula;

	@FXML
	private TextField campoHora;

	@FXML
	private TextField campoMinutos;

	@FXML
	void adicionarAlunoNaAula(MouseEvent event) {
		String cpfAluno = campoCpfAlunoAdicionar.getText();
		String idAula = campoIDAulaAdicionar.getText();
		if (cpfAluno.equals("") || idAula.equals("")) {
			Utils.mostrarAlerta("Os campos devem ser preenchidos!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(cpfAluno))
				|| !(Utils.checarSeStringContemApenasNumeros(idAula))) {
			Utils.mostrarAlerta("Os campos de CPF e Id só aceitam números!");
		} else {
			try {
				
				Aluno aluno = alunoController.buscarAluno(cpfAluno);
				
				if(aluno.getStatusDaMensalidade() == StatusDaMensalidadeDoAluno.NAO_PAGO) {
					Utils.mostrarAlerta("Não é possivel adicionar o aluno porque ele não pagou a mensalidade!");
				}else {
					
					aulaController.adicionarAlunoEmAula(cpfAluno, idAula);
					Utils.mostrarAlerta("Aluno adicionado na aula com sucesso!");
					campoCpfAlunoAdicionar.setText("");
					campoIDAulaAdicionar.setText("");
				}
				
			} catch (AlunoNaoExisteException e) {

				Utils.mostrarAlerta(e.getMessage());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (AulaNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			} catch (AlunoJaMarcadoNaAulaException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}
	}

	@FXML
	void onBotaoSairClicked() {

		loginFuncionarioController.fazerLogout();
		try {
      
			Parent novaTela = FXMLLoader.load(getClass().getResource("TelaFuncionarioView.fxml"));
			botaoSair.getScene().setRoot(novaTela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void agendarAula(MouseEvent event) {
		LocalDateTime dataAula = null;
		TipoDeAula tipoAula = campoTipoAula.getValue();
		TipoDeTreino tipoTreino = campoTreino.getValue();
		String hora = campoHora.getText();
		String minutos = campoMinutos.getText();

		if (campoDataAgendarAula.getValue() == null || hora.equals("") || minutos.equals("") || tipoAula == null
				|| tipoTreino == null) {
			Utils.mostrarAlerta("Algum dos campos está vazio");
		} else if (!(Utils.checarSeStringContemApenasNumeros(hora)) || !(Utils.checarSeStringContemApenasNumeros(minutos))) {
			Utils.mostrarAlerta("Os campos de hora e minutos só aceitam números!");
		} else if (campoDataAgendarAula.getValue().compareTo(LocalDate.now()) < 0) {
			Utils.mostrarAlerta("A data não pode ser menor que a data de hoje");
		} else if (Integer.valueOf(hora) > 23 || Integer.valueOf(hora) < 0 || Integer.valueOf(minutos) > 59
				|| Integer.valueOf(minutos) < 0) {
			Utils.mostrarAlerta("O valores de hora ou minutos não podem ser aceitos");
		} else {
			try {
				dataAula = LocalDateTime.of(campoDataAgendarAula.getValue(),
						LocalTime.of(Integer.parseInt(hora), Integer.parseInt(minutos)));

				Aula aulaParaAgendar = new Aula(dataAula, tipoAula, tipoTreino, funcionarioLogado.getId(), null);

				aulaController.criarAula(aulaParaAgendar);

			} catch (AulaJaExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}

	}

	private void limparCamposAbaRemoverAlunoDeAula() {
		campoDataAgendarAula.setValue(null);
		campoTipoAula.setValue(null);
		campoTreino.setValue(null);
		campoHora.setText("");
		campoMinutos.setText("");
	}

	
	
	@FXML
	void removerAlunoDaAula(MouseEvent event) {
		String cpfAluno = campoCpfAlunoRemover.getText();
		String idAula = campoIDAulaRemover.getText();

		if (cpfAluno.equals("") || idAula.equals("")) {
			Utils.mostrarAlerta("Os campos devem ser preenchidos!");
		} else if (!(Utils.checarSeStringContemApenasNumeros(cpfAluno))
				|| !(Utils.checarSeStringContemApenasNumeros(idAula))) {
			Utils.mostrarAlerta("Os campos de CPF e Id só aceitam números!");
		} else {
			try {
				Aula aula = aulaController.buscarAula(idAula);
				Aluno aluno = alunoController.buscarAluno(cpfAluno);

				aulaController.removerAlunoDeAula(cpfAluno, idAula);
				Utils.mostrarAlerta("Aluno removido com sucesso!");
				limparCamposAbaRemoverAlunoDeAula();
				
			} catch (AlunoNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (AulaNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			} catch (AlunoNaoEstaMarcadoNaAulaException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}


	}

	@FXML
	void removerAula(MouseEvent event) {
		
		String idAula = campoRemoverAula.getText();
		if (idAula.equals("")) {
			Utils.mostrarAlerta("O campo de ID deve ser preenchido");
		} else if (!(Utils.checarSeStringContemApenasNumeros(idAula))) {
			Utils.mostrarAlerta("O campo de Id só aceita números!");
		} else {
			try {
				aulaController.deletarAula(idAula);
				
			} catch (AulaNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}

		
	}
	void irParaTela(String caminho) {
		try {
			Parent telaFxml = FXMLLoader.load(getClass().getResource(caminho));
			Scene cenaTela = new Scene(telaFxml);
			Stage novaTela = new Stage();
			novaTela.setScene(cenaTela);
			btnVerAulasAgendadas.getScene().getRoot().setDisable(true);
			novaTela.showAndWait();
			btnVerAulasAgendadas.getScene().getRoot().setDisable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void verAulasAgendada(MouseEvent event) {
		irParaTela("TelaAulasAgendadasProfessor.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList listaDeAulas = FXCollections.observableArrayList(TipoDeAula.values());

		funcionarioLogado = loginFuncionarioController.getFuncionarioLogado();
		textoNome.setText(funcionarioLogado.getNome());

		campoTipoAula.setItems(listaDeAulas);
		campoTipoAula.setValue(TipoDeAula.INDIVIDUAL);

		campoTreino.setItems(treinos);
		campoTreino.setValue(TipoDeTreino.MUSCULACAO);
	}

}