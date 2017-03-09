/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author u15194
 */
public class FXMLDocumentController implements Initializable {

	@FXML
	private TextField txtUsuario;
	@FXML
	private PasswordField pssSenha;

	@FXML
	public void handleBtnLoginAction(ActionEvent e) {
		String user = txtUsuario.getText();
		String pass = pssSenha.getText();

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Importante!");
		alert.setHeaderText("Resulatado da operação");
		
		if (logar(user, pass)) {
			alert.setContentText(pass);
		} else {
			alert.setContentText("Não logou");
		}

		alert.showAndWait();
	}
	
	public boolean logar (String user, String password){
		return verificaLogin(user, password);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	private static Boolean verificaLogin(java.lang.String nomeUsuario, java.lang.String senhaUsuario) {
		br.cotuca.unicamp.ServiceLogin_Service service = new br.cotuca.unicamp.ServiceLogin_Service();
		br.cotuca.unicamp.ServiceLogin port = service.getServiceLoginPort();
		return port.verificaLogin(nomeUsuario, senhaUsuario);
	}
}
