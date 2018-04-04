package ch.makery.address.view;

import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialogueController {
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField priceField;
	
	private Stage dialogueStage;
	private Person person;
	private boolean okClicked = false;

	@FXML
	private void initialize() {

	}

	public void setDialogueStage(Stage dialogueStage) {
		this.dialogueStage = dialogueStage;
	}

	public void setPerson(Person person) {
		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		streetField.setText(person.getStreet());
		postalCodeField.setText(person.getPostalCode());
		cityField.setText((person.getPostalCode()));
		priceField.setText(person.getPrice());

	}

	public boolean isOKClicked() {
		return okClicked;
	}

	@FXML
	private void handleOK() {
		if (isInputValid()) {
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setStreet(streetField.getText());
			person.setPostalCode(postalCodeField.getText());
			person.setCity(cityField.getText());
			person.setPrice(priceField.getText());
			okClicked = true;
			dialogueStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogueStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";
		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "No valid street!\n";
		}
		if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
			errorMessage += "No valid postal code!\n";
		} else {
			try {
				Integer.parseInt(postalCodeField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Not valid postal code(input int)";
			}
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogueStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}

	}
}
