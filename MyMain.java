package com.company.JavaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyMain extends Application {
	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop");
	}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("init");
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		Pane rootNode = loader.load();

		Scene scene = new Scene(rootNode, 300, 275);
		System.out.println("start");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool ");
		primaryStage.show();
		//primaryStage.setResizable(false);
	}
}
