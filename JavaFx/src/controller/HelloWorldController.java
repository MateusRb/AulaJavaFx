package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloWorldController {

	@FXML
	private TextField tfTexto;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Label lblMsgSalvar;

	@FXML
	private TableView<String> tblNomes;

	@FXML
	private TableColumn<String, String> colNome;

	// Será executado logo após o arquivo xml ser carregado
	// é a primeira coisa a ser executado depois de carregar o xml
	@FXML
	private void initialize() {

	}

	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.CONFIRMATION, "Deseja realmente Excluir?", ButtonType.CANCEL, ButtonType.OK);
		alerta.show();

	}

	@FXML
	void salvar(ActionEvent event) {
		// Pega o valor digitado no text field
		String nome = tfTexto.getText();
		String msg = "Salvo com sucesso o cadastro: ";
		// seta no label a mensagem de salvo com sucesso
		lblMsgSalvar.setText(msg + nome);
		lblMsgSalvar.getStyleClass().add("msgSalvar");
		tblNomes.getItems().add(nome);
	}

}
