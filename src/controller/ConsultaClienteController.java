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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsultaClienteController implements Initializable {
	@FXML
	static VBox clienteConsulta;
	@FXML
	Button cadastro;

	@FXML
	public void Cadastrar(ActionEvent e) throws IOException {

		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/CadastraCliente.fxml"));

		Stage janela = (Stage) cadastro.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));
	}

	@FXML
	public void Editar(ActionEvent e) throws IOException {

		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ClienteController.fxml"));

		Stage janela = (Stage) cadastro.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));
	}

	@FXML
	public void Remover(ActionEvent e) throws IOException {

		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ClienteController.fxml"));

		Stage janela = (Stage) cadastro.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
