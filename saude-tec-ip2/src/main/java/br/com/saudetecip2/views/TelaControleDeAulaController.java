package br.com.saudetecip2.views;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.AlunoController;
import br.com.saudetecip2.controller.Aulacontroller;
import br.com.saudetecip2.controller.FuncionarioController;
import br.com.saudetecip2.domain.enums.CargoFuncionario;
import br.com.saudetecip2.domain.enums.TipoDeAula;
import br.com.saudetecip2.domain.enums.TipoDeTreino;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.model.Aula;
import br.com.saudetecip2.domain.model.Funcionario;
import br.com.saudetecip2.exceptions.AlunoNaoExisteException;
import br.com.saudetecip2.exceptions.AulaJaExisteException;
import br.com.saudetecip2.exceptions.AulaNaoExisteException;
import br.com.saudetecip2.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class TelaControleDeAulaController implements Initializable {

	FuncionarioController funcionarioController = new FuncionarioController();
	Aulacontroller aulaController = new Aulacontroller();
	AlunoController alunoController = new AlunoController();
	private HashMap<String, Long> mapaEntreIdENomeDeProdessor = new HashMap();

	@FXML
	private Tab opAgendarAula;

	@FXML
	private Text txtID;

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
	private Label lblCpfAluno;

	@FXML
	private Label lbIDAula;

	@FXML
	private TextField campCpfAluno;

	@FXML
	private TextField campoIDAula;

	@FXML
	private Button btnAdicionarAlunoNaAula;

	@FXML
	private Label lbIDAluno;

	@FXML
	private Label lbIDAula1;

	@FXML
	private TextField campoIDAluno;

	@FXML
	private TextField campoIDAula1;

	@FXML
	private Button btnRemoverAlunoDaAula;

	@FXML
	private ChoiceBox<String> campoProfessor;

	@FXML
	private ChoiceBox<TipoDeAula> campoTipoAula;

	@FXML
	private TextField campoHora;

	@FXML
	private TextField campoMinutos;

	@FXML
	void adicionarAlunoNaAula(MouseEvent event) {
		String cpfAluno = campCpfAluno.getText();
		String idAula = campoIDAula.getText();

		if (cpfAluno.equals("") || idAula.equals("")) {
			Utils.mostrarAlerta("Os campos devem ser preenchidos!");
		}else {
			try {
				Aula aula = aulaController.buscarAula(new Long(idAula));
				Aluno aluno = alunoController.buscarAluno(cpfAluno);
				
				aula.getAlunos().add(aluno);
				
			} catch (AlunoNaoExisteException e) {
				
				Utils.mostrarAlerta(e.getMessage());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AulaNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}

	}

	@FXML
	void agendarAula(MouseEvent event) {

		Timestamp dataAula = null;
		String professor = campoProfessor.getValue();
		TipoDeAula tipoAula = campoTipoAula.getValue();
		TipoDeTreino tipoTreino = campoTreino.getValue();
		String hora = campoHora.getText();
		String minutos = campoMinutos.getText();

		if (campoDataAgendarAula.getValue() == null || hora.equals("") || minutos.equals("")) {
			Utils.mostrarAlerta("Algum dos campos está vazio");
		} else {
			try {
				dataAula = Timestamp.valueOf(LocalDateTime.of(campoDataAgendarAula.getValue(),
						LocalTime.of(Integer.parseInt(hora), Integer.parseInt(minutos))));
				Long idProfessor = mapaEntreIdENomeDeProdessor.get(professor);
				Aula aulaParaAgendar = new Aula(dataAula, tipoAula, tipoTreino, idProfessor, null);
				aulaController.criarAula(aulaParaAgendar);
			} catch (AulaJaExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}
	}

	@FXML
	void removerAlunoDaAula(MouseEvent event) {
	}

	@FXML
	void removerAula(MouseEvent event) {

		String idAula = campoRemoverAula.getText();
		if (idAula.equals("")) {
			Utils.mostrarAlerta("O campo de ID deve ser preenchido");
		} else {
			try {
				aulaController.deletarAula(Long.valueOf(idAula));
			} catch (AulaNaoExisteException e) {
				Utils.mostrarAlerta(e.getMessage());
			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Funcionario> professores = funcionarioController.buscarFuncionariosPorCargo(CargoFuncionario.PROFESSOR);

		for (Funcionario funcinario : professores) {
			mapaEntreIdENomeDeProdessor.put(funcinario.getNome(), funcinario.getId());
		}

		ObservableList listaProfessores = FXCollections.observableArrayList(mapaEntreIdENomeDeProdessor.keySet());
		campoProfessor.setItems(listaProfessores);

	}

}