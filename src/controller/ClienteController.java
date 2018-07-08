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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Cliente;
import model.ClienteDAO;

public class ClienteController implements Initializable {
	private ClienteDAO cliente;

	@FXML
	static AnchorPane clienteCadastro;
	@FXML
	Button cancelar;
	@FXML
	private TextField nome;
	@FXML
	private TextField rg;
	@FXML
	private TextField telefone;

	public ClienteController() {
		cliente = new ClienteDAO();
	}

	@FXML
	public void cancelar(ActionEvent e) throws IOException {
		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ConsultaCliente.fxml"));
		Stage janela = (Stage) cancelar.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));

	}

	@FXML
	public void salvaform(ActionEvent event) {
		try {
			cliente.create(new Cliente(Integer.parseInt(rg.getText()), nome.getText(), telefone.getText()));
			limpaCampos();
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Congrats");
			alerta.setHeaderText(null);
			alerta.setContentText(nome.getText() + " Salvo!");
			alerta.showAndWait();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Deu ruim!");
			alerta.setHeaderText("Deu Ruim!");
			alerta.setContentText(e.getMessage());
			alerta.showAndWait();
		}
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		limpaCampos();
	}

	private void limpaCampos() {
		nome.clear();
		rg.clear();
		telefone.clear();
	}
}
