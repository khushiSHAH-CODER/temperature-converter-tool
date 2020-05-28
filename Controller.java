package com.company.JavaFx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	public javafx.scene.control.Label welcomeLable;
	public ChoiceBox choiceBox;
	public javafx.scene.control.Button convertButton;
	public TextField inputField;

	private static  final String c_to_f_txt ="Celsius to Fahrenheit";
	private static final String f_to_c_txt="Fahrenheit to Celsius";
	private boolean isC_to_F=true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceBox.getItems().add(c_to_f_txt);
		choiceBox.getItems().add(f_to_c_txt);
		choiceBox.setValue(c_to_f_txt);
		choiceBox.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
			if (newValue.equals(c_to_f_txt)) {
				isC_to_F = true;
			} else {
				isC_to_F = false;
			}
		});

		convertButton.setOnAction(event -> {
			convert();
		});
	}
		private void convert(){
		String input =inputField.getText();
			float enteredTemperature =0.0f;
			float newTemperature=0.0f;
		try {
			 enteredTemperature =Float.parseFloat(input);
		}
		catch (Exception e){
			warnUser();
			return ;
		}
			if(isC_to_F){
				newTemperature=(enteredTemperature*9/5)+32;
			}
			else{
				newTemperature=(enteredTemperature-32)*5/9;
			}
			display(newTemperature);
		}
		private void display(float newTemperature){
		String unit=isC_to_F?"F" : "C";
			System.out.println("The new Temperature is "+newTemperature+" "+unit);

			Alert alert =new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Result");
			alert.setContentText("The new Temperature is "+newTemperature+" "+unit);
			alert.show();
		}
		private  void warnUser(){
			Alert alert =new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Please input valid temperature");
			alert.show();
		}
}
