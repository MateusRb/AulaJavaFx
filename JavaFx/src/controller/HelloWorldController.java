package controller;

import java.util.Optional;

import javafx.beans.property.ReadOnlyStringWrapper;
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
		// seta o responsavel por fabricar os valores da coluna
		colNome.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue()));

	}

	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.CONFIRMATION, "Deseja realmente Excluir?", ButtonType.CANCEL, ButtonType.OK);
		// desativando o comportamendo padrão
		Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);

		// optional do java 8 executa o show e fica aguardando o click do botão
		final Optional<ButtonType> result = alerta.showAndWait();
		// se o click foi no ok executa os botões abaixo
		if (result.get() == ButtonType.OK) {
			// Pega a linha selecionada
			int posicaoTabela = tblNomes.getSelectionModel().getSelectedIndex();
			// remove da tabela a linha selecionada
			tblNomes.getItems().remove(posicaoTabela);
			lblMsgSalvar.setText("Registro Excluido com sucesso");
			lblMsgSalvar.getStyleClass().remove("msgSalvar");
			lblMsgSalvar.getStyleClass().add("msgExcluir");
		}
	}

	@FXML
	void salvar(ActionEvent event) {
		// Pega o valor digitado no text field
		String nome = tfTexto.getText();
		String msg = "Salvo com sucesso o cadastro: ";
		// seta no label a mensagem de salvo com sucesso
		lblMsgSalvar.setText(msg + nome);
		lblMsgSalvar.getStyleClass().remove("msgExcluir");
		lblMsgSalvar.getStyleClass().add("msgSalvar");
		// seta cada um dos nomes para dentro da tabela
		tblNomes.getItems().add(nome);
	}

}
