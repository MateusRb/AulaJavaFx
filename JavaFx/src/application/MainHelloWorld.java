package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainHelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
			// cria a cena com base no root(Anchor Pane)
			Scene scene = new Scene(root);
			// seta o arquivo de css que será usado no formulário
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// seta para o palco a cena
			primaryStage.setScene(scene);
			// faz mostrar a tela
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
