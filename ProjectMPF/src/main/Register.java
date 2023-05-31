package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Register {

	Stage stage;
	Scene scene;
	GridPane gp;
	Label email, password, confirmPassword, register;
	TextField emailtf;
	PasswordField passwordpf, confirmPasswordpf;
	HBox btnHBox;
	Button registerBtn, loginBtn, resetBtn;
	Alert a;
	
	private void initialize() {
		register = new Label("Register");
		email = new Label("Email");
		password = new Label("Password");
		confirmPassword = new Label("Confirm Password");
		
		emailtf = new TextField();
		passwordpf = new PasswordField();
		confirmPasswordpf = new PasswordField();
		
		registerBtn = new Button("Register");
		loginBtn = new Button("Login");
		resetBtn = new Button("Reset");
		
		
		btnHBox = new HBox();
		btnHBox.getChildren().addAll(loginBtn, registerBtn, resetBtn);
		
		
		
		gp = new GridPane();
		gp.add(register, 0, 0);
		gp.add(email, 0, 1);
		gp.add(password, 0, 2);
		gp.add(confirmPassword, 0, 3);
		gp.add(emailtf, 1, 1);
		gp.add(passwordpf, 1, 2);
		gp.add(confirmPasswordpf, 1, 3);
		gp.add(btnHBox, 1, 4);
		gp.setAlignment(Pos.CENTER);
		
		scene = new Scene(gp, 500, 500);
	}
	
	private void clickBtn() {
		loginBtn.setOnMouseClicked(e->{
			new Login(stage);
		});
		
		registerBtn.setOnMouseClicked(e->{
			if(emailtf.getText().toString().isBlank() 
				|| !(emailtf.getText().toString().endsWith("@email.com"))
				//|| ini buat only one @ 
				|| emailtf.getText().toString().contains(" ")
				|| emailtf.getText().toString().startsWith("@")
				//gaboleh diregis sebelumnya
				|| passwordpf.getText().toString().isBlank()
				|| confirmPasswordpf.getText().toString().isBlank()
				|| !(passwordpf.getText().toString().equals(confirmPasswordpf.getText().toString()))) {
				
				a = new Alert(AlertType.ERROR);
				a.setContentText("Please fill username, password, or confirm password");
				a.show();
			}else {
				new Login(stage);
			}
		});
		
		resetBtn.setOnMouseClicked(e->{
			emailtf.clear();
			passwordpf.clear();
			confirmPasswordpf.clear();
		});
	}
	
	public Register(Stage stage) {
		// TODO Auto-generated constructor stub
		initialize();
		clickBtn();
		this.stage = stage;
		this.stage.setTitle("Register");
		this.stage.setScene(scene);
		this.stage.show();
	}

}
