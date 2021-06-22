package br.com.saudetecip2.views;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
public class LoginAlunoController {
	@FXML
    private Button botaoVoltar;

    @FXML
    private TextField campoIdAluno;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoEntrar;

    @FXML
    void onBotaoEntrarClicked(MouseEvent event) {
    		
    }

    @FXML
    void onBotaoVoltarClicked(MouseEvent event) {
    	irParaHome();
    }
    
    private void irParaHome() {
    	try {
    		Parent telaHome = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
    		botaoVoltar.getScene().setRoot(telaHome);
    	}
    	catch(Exception e) {
    		System.out.println("Erro ao ir para a Home!");
    	}
    }
    
    private void irParaAreaAluno() {
    	try {
    		Parent telaHome = FXMLLoader.load(getClass().getResource("/views/AreaAluno.fxml"));
    		botaoVoltar.getScene().setRoot(telaHome);
    	}
    	catch(Exception e) {
    		System.out.println("Erro ao ir para a Home!");
    	}
    }
}
