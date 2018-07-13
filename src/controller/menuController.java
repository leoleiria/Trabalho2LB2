package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class menuController implements Initializable {
	@FXML
	static AnchorPane menuPrincipal;
	@FXML 
	Button cliente;
	@FXML 
	Button aviao;

	@FXML
	public void Cliente(ActionEvent event) throws IOException {

		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ConsultaCliente.fxml"));
	
		Stage janela = (Stage) cliente.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));
	
	}	@FXML
	public void Aviao(ActionEvent event) throws IOException {

		Parent aviaoCadastro = FXMLLoader.load(getClass().getResource("/view/ConsultaAviao.fxml"));
	
		Stage janela = (Stage) aviao.getScene().getWindow();
		janela.setScene(new Scene(aviaoCadastro));
	
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
