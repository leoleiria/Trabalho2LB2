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
import model.Aviao;
import model.AviaoDAO;
import model.Contexto;

public class AviaoController implements Initializable {
	@FXML
	static VBox aviaoConsulta;
	@FXML
	private TableView<Aviao> tableViewAviao;

	private AviaoDAO aviao;
	private List<Aviao> listaAviao;
	private ObservableList<Aviao> observableListaAviao;
	@FXML
	Button cancelar;
	@FXML
	private TextField nome;
	@FXML
	private TextField idString;
	@FXML
	private TextField nroAssentosString;
	@FXML
	Button cadastro;
	@FXML
	Button editar;
	@FXML
	Button menu;
	@FXML
	private TableColumn<Aviao, String> tableColumnId;
	@FXML
	private TableColumn<Aviao, String> tableColumnNome;
	@FXML
	private TableColumn<Aviao, String> tableColumnAssentos;
	private Aviao aviaoSelecionado;

	public void listarAviao() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idString"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnAssentos.setCellValueFactory(new PropertyValueFactory<>("nroAssentosString"));

		listaAviao = AviaoDAO.listar();
		observableListaAviao = FXCollections.observableArrayList(listaAviao);
		tableViewAviao.setItems(observableListaAviao);
	}

	@FXML
	public void Cadastrar(ActionEvent e) throws IOException {

		Parent aviaoCadastro = FXMLLoader.load(getClass().getResource("/view/CadastraAviao.fxml"));

		Stage janela = (Stage) cadastro.getScene().getWindow();
		janela.setScene(new Scene(aviaoCadastro));

	}

	@FXML
	public void Editar(ActionEvent e) throws IOException {
		Aviao AviaoSelecionado = tableViewAviao.getSelectionModel().getSelectedItem();
		if (AviaoSelecionado != null) {
			Contexto.getContexto().setValor("aviao", AviaoSelecionado);
			Parent editAviao = FXMLLoader.load(getClass().getResource("/view/EditaAviao.fxml"));
			Stage janela = (Stage) editar.getScene().getWindow();
			janela.setScene(new Scene(editAviao));
		} else {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Selecionar");
			alerta.setHeaderText(null);
			alerta.setContentText("Precisa selecionar um aviao para editar");
			alerta.showAndWait();

		}
	}

	@FXML
	public void Remover(ActionEvent e) throws IOException {
		Aviao AviaoSelecionado = tableViewAviao.getSelectionModel().getSelectedItem();
		AviaoDAO aviao = new AviaoDAO();
		aviao.deleta(AviaoSelecionado.getId());
	}

	@FXML
	public void Menu(ActionEvent e) throws IOException {

		Parent aviaoCadastro = FXMLLoader.load(getClass().getResource("/view/MenuView.fxml"));

		Stage janela = (Stage) menu.getScene().getWindow();
		janela.setScene(new Scene(aviaoCadastro));
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		listarAviao();

	}


}
