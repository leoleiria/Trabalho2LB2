package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDAO;
import model.Contexto;

public class CliController implements Initializable {
	@FXML
	static VBox clienteConsulta;
	@FXML
	private TableView<Cliente> tableViewClientes;

	private ClienteDAO cliente;
	private List<Cliente> listaClientes;
	private ObservableList<Cliente> observableListaClientes;
	@FXML
	Button cancelar;
	@FXML
	private TextField nome;
	@FXML
	private TextField rg;
	@FXML
	private TextField telefone;
	@FXML
	Button cadastro;
	@FXML
	Button editar;
	@FXML
	Button menu;
	@FXML
	private TableColumn<Cliente, String> tableColumnRg;
	@FXML
	private TableColumn<Cliente, String> tableColumnNome;
	@FXML
	private TableColumn<Cliente, String> tableColumnTelefone;
	private Cliente clienteSelecionado;

	public void listarCli() {
		tableColumnRg.setCellValueFactory(new PropertyValueFactory<>("rgString"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

		listaClientes = ClienteDAO.listar();
		System.out.println(listaClientes.get(0).getRgString());
		observableListaClientes = FXCollections.observableArrayList(listaClientes);
		tableViewClientes.setItems(observableListaClientes);
	}

	@FXML
	public void Cadastrar(ActionEvent e) throws IOException {

		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/CadastraCliente.fxml"));

		Stage janela = (Stage) cadastro.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));

	}

	@FXML
	public void Editar(ActionEvent e) throws IOException {
		Cliente ClienteSelecionado = tableViewClientes.getSelectionModel().getSelectedItem();
		if (ClienteSelecionado != null) {
			Contexto.getContexto().setValor("cliente", ClienteSelecionado);
			Parent editCli = FXMLLoader.load(getClass().getResource("/view/EditaCliente.fxml"));
			Stage janela = (Stage) editar.getScene().getWindow();
			janela.setScene(new Scene(editCli));
		} else {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Selecionar");
			alerta.setHeaderText(null);
			alerta.setContentText("Precisa selecionar um cliente para editar");
			alerta.showAndWait();

		}
	}

	@FXML
	public void Remover(ActionEvent e) throws IOException {
		Cliente ClienteSelecionado = tableViewClientes.getSelectionModel().getSelectedItem();
		ClienteDAO cliente = new ClienteDAO();
		cliente.deletaRG(ClienteSelecionado.getRg());
	}

	@FXML
	public void Menu(ActionEvent e) throws IOException {

		Parent clienteCadastro = FXMLLoader.load(getClass().getResource("/view/MenuView.fxml"));

		Stage janela = (Stage) menu.getScene().getWindow();
		janela.setScene(new Scene(clienteCadastro));
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		listarCli();

	}


}
