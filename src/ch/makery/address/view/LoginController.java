package ch.makery.address.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
	    @FXML 
	    private Text actiontarget;
	
	    @FXML
	    private Label Status;
	    
	    @FXML
	    private TextField UserField ;

	    @FXML
	    private PasswordField PassField ;
	    
	    @FXML
	    private Button LoginButton;

	    @FXML
	    private void login() {
	       if(UserField.getText().equals("user") && PassField.getText().equals("pass")) {
	    	   Status.setText("Login Succesful");
	       } else {
	    	   Status.setText("Login Failed");
	       }
	    }
	    @FXML 
	    public void Login(ActionEvent event) {
	    	LoginButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					System.out.println("!");
				}
		    });
	    }
		@FXML 
		public void Create(ActionEvent event) {
	        //actiontarget.setText("Sign in button pressed");
	    }
}

