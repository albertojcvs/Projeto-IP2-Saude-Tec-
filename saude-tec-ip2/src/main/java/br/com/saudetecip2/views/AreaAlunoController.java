package br.com.saudetecip2.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.com.saudetecip2.controller.LoginAlunoController;
import br.com.saudetecip2.domain.enums.StatusDaMensalidadeDoAluno;
import br.com.saudetecip2.domain.model.Aluno;
import br.com.saudetecip2.domain.model.Aula;

public class AreaAlunoController implements Initializable {
	private Aluno alunoLogado;
	LoginAlunoController loginAlunoController = LoginAlunoController.getInstance();
	
		@FXML
	    private Text textoNomeAluno;

	    @FXML
	    private Text textoIDAluno;

	    @FXML
	    private TableView<Aula> tabelaDeAulasAgendadas;

	    public Aluno getAlunoLogado() {
			return alunoLogado;
		}
	    public void setAlunoLogado(Aluno alunoLogado) {
			this.alunoLogado = alunoLogado;
		}
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	alunoLogado = loginAlunoController.getAlunoLogado();
	    	textoNomeAluno.setText(alunoLogado.getNome());
	    }
}
