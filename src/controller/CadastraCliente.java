package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;
import model.ClienteDAO;

public class ClienteController implements Initializable {
	private ClienteDAO cliente;

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
	private void salvaform(ActionEvent event) {
		try {
			cliente.create(new Cliente(Integer.parseInt(rg.getText()), nome.getText(), telefone.getText()));
			limpaCampos();
			Alert alerta  = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Congrats");
			alerta.setHeaderText(null);
			alerta.setContentText(nome.getText()+" Salvo!");
			alerta.showAndWait();

		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Deu ruim!");
			alerta.setHeaderText("Deu Ruim!");
			alerta.setContentText(e.getMessage());
			alerta.showAndWait();
		}
	}

	@FXML
	private void cancelar() {
		limpaCampos();
	}

	@Override
	private void initialize(URL url, ResourceBundle rb) {
		limpaCampos();
	}

	private void limpaCampos() {
		nome.clear();
		rg.clear();
		telefone.clear();
	}
}
