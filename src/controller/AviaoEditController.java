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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Aviao;
import model.AviaoDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Contexto;

public class AviaoEditController implements Initializable{
	private int id;
	private AviaoDAO aviaoDAO;
	@FXML
	static AnchorPane aviaoEdit;
	@FXML
	Button cancelar;
	@FXML
	Button salvar;
	@FXML
	private TextField nome;
	@FXML
	private TextField assentos;


	
	@FXML
	public void cancelar(ActionEvent e) throws IOException {
		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ConsultaAviao.fxml"));
		Stage janela = (Stage) cancelar.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));

	}

	@FXML
	public void salvaform(ActionEvent event) {
		try {
			aviaoDAO.altera(id, nome.getText(), assentos.getText());
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
		setCampos();
	}
	
	public void setCampos() {
		Aviao aviao = (Aviao) Contexto.getContexto().getValor("aviao");
		nome.setText(aviao.getNome());
		assentos.setText(aviao.getNroAssentosString());
		id = aviao.getId();
	}
}
