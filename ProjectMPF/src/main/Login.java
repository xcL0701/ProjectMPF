package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Login {

	Stage stage;
	Scene scene;
	GridPane gp;
	Label email, password, legho;
	TextField emailtf;
	PasswordField passwordpf;
	HBox btnHBox;
	Button registerBtn, loginBtn;
	Alert a;
	
	private void initialize() {
		email = new Label("Email");
		password = new Label("Password");
		legho = new Label("Legho");
		
		emailtf = new TextField();
		passwordpf = new PasswordField();
		
		registerBtn = new Button("Register");
		loginBtn = new Button("Login");
		
		
		btnHBox = new HBox();
		btnHBox.getChildren().addAll(registerBtn, loginBtn);
		
		
		
		gp = new GridPane();
		gp.add(legho, 0, 0);
		gp.add(email, 0, 1);
		gp.add(password, 0, 2);
		gp.add(emailtf, 1, 1);
		gp.add(passwordpf, 1, 2);
		gp.add(btnHBox, 1, 3);
		gp.setAlignment(Pos.CENTER);
		
		scene = new Scene(gp, 500, 500);
	}
	

	private void clickBtn() {
		loginBtn.setOnMouseClicked(e->{
			if(emailtf.getText().toString().isBlank() || passwordpf.getText().toString().isBlank()) {
				a = new Alert(AlertType.ERROR);
				a.setContentText("Please make sure that your email and password are correct");
				a.show();
			}else if(emailtf.getText().toString().equals("admin")
					& passwordpf.getText().toString().equals("admin")){
				new Admin(stage);
			}else {
				new Welcome(stage);
			}
		});
		
		registerBtn.setOnMouseClicked(e->{
			new Register(stage);
		});
	}


	public Login(Stage stage) {
		// TODO Auto-generated method stub
		initialize();
		clickBtn();
		
		this.stage = stage;
		this.stage.setTitle("Login");
		this.stage.setScene(scene);
//		arg0.getIcons().add(new Image(Main.class.getResourceAsStream("logo.png")));
		this.stage.show();
	}
}
