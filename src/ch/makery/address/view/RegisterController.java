package ch.makery.address.view;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class RegisterController {
	    
	    @FXML
	    private TextField FirstName ;
	    
	    @FXML
	    private TextField LastName ;
	    
	    @FXML
	    private TextField Username ;

	    @FXML
	    private PasswordField Password ;
	    
	    @FXML
	    private PasswordField Confirm ;
	    
	    @FXML
	    private Button Create;
	    
	    @FXML
	    private Button Cancel;

	    

	    @FXML 
	    public void Create(ActionEvent event) {
	    	Create.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent event) {
	    	        if((FirstName.getText().isEmpty() && LastName.getText().isEmpty()) || (FirstName.getText().isEmpty() || LastName.getText().isEmpty())) {
	    	            Alert Name = new Alert(Alert.AlertType.ERROR);
	    	            Name.setTitle("Form Error!");
	    	            Name.setHeaderText("Please enter your name");
	    	            return;
	    	        }
	    	        if(Username.getText().isEmpty()) {
	    	        	Alert User = new Alert(Alert.AlertType.ERROR);
	    	            User.setTitle("Form Error!");
	    	            User.setHeaderText("Please enter your email id");
	    	            return;
	    	        }
	    	        if((Password.getText().isEmpty() && Confirm.getText().isEmpty()) || (Password.getText().isEmpty() || Confirm.getText().isEmpty())) {
	    	            Alert emptyPassword = new Alert (Alert.AlertType.ERROR);
	    	            emptyPassword.setTitle("Form Error!");
	    	            emptyPassword.setHeaderText("Please enter a password");
	    	            return;
	    	        }
	    	        if(!Password.getText().equals(Confirm)) {
	    	        	Alert PassConf = new Alert (Alert.AlertType.ERROR);
	    	        	PassConf.setTitle("Form Error!");
	    	        	PassConf.setHeaderText("Password does not match");
	    	        	return;
	    	        }

	    	       Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
	    	       Confirmation.setTitle("Welcome");
	    	       Confirmation.setHeaderText("Registration Succsesful");
	    	       Confirmation.setContentText(FirstName.getText() + " " + LastName.getText());
	    	       return;
	    	    }
	    	});
	    }
		@FXML 
		public void CreateButton(ActionEvent event) {
		   	Create.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							System.out.println("!");
						}
				    });
			    }
		public void CancelButton(ActionEvent event) throws IOException{
		   	Cancel.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							System.out.println("!");
							try {
								Parent Login_Page = FXMLLoader.load(getClass().getResource("/ViewLogin/Login.fxml"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				    });
			    }
}

