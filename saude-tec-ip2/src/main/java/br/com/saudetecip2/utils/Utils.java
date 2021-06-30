package br.com.saudetecip2.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Utils {
	
	public static void mostrarAlerta(String mensagem) {
		Alert alertaErro = new Alert(AlertType.NONE, mensagem, ButtonType.OK);
		alertaErro.setTitle("Erro!");
		alertaErro.showAndWait();
	}
	
	public static boolean checarSeStringContemApenasNumeros(String string){
		final String regexSoNumeros = "^[0-9]*$";;
		
		return string.matches(regexSoNumeros);
		
	}
}
