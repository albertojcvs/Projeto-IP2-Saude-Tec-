package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControllerHome {

	  @FXML
	    private Text mainText;
	 
	
	    @FXML
	    private Button mainButton;

	    @FXML
	    void clicar(MouseEvent event) {
	    	mainText.setText("Botão clicado");
	    }

}
