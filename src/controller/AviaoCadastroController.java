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
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Aviao;
import model.AviaoDAO;
import model.Cliente;
import model.ClienteDAO;

public class AviaoCadastroController implements Initializable {
	private AviaoDAO aviao;

	@FXML
	static AnchorPane aviaoCadastro;
	@FXML
	Button cancelar;
	@FXML
	private TextField nome;
	@FXML
	private TextField assentos;

	public AviaoCadastroController() {
		aviao = new AviaoDAO();
	}

	@FXML
	public void cancelar(ActionEvent e) throws IOException {
		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ConsultaAviao.fxml"));
		Stage janela = (Stage) cancelar.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));

	}

	@FXML
	public void salvaform(ActionEvent event) {
		try {
			aviao.create(new Aviao(nome.getText(), Integer.parseInt(assentos.getText())));
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
		assentos.clear();
	}
	

}