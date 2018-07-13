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
import model.Cliente;
import model.ClienteDAO;
import model.Contexto;

public class ClienteEditController implements Initializable{
	private ClienteDAO clienteDAO;
	static int rg;
	@FXML
	static AnchorPane clienteEdit;
	@FXML
	Button cancelar;
	@FXML
	Button salvar;
	@FXML
	private TextField nome;
	@FXML
	private TextField telefone;


	
	@FXML
	public void cancelar(ActionEvent e) throws IOException {
		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/ConsultaCliente.fxml"));
		Stage janela = (Stage) cancelar.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));

	}

	@FXML
	public void salvaform(ActionEvent event) {
		try {
			clienteDAO.altera(nome.getText(), telefone.getText(), rg);
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
		Cliente cliente = (Cliente) Contexto.getContexto().getValor("cliente");
		nome.setText(cliente.getNome());
		telefone.setText(cliente.getTelefone());
		rg = cliente.getRg();
	}
}
