package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class BookStoreViewController {

	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label priceLabel;
	
	private MainApp mainApp;

	public BookStoreViewController() {
	}

	@FXML
	private void initialize() {

		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		showBookStoreDetails(null);
		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showBookStoreDetails(newValue));
	}

	@FXML
	private void handleDeleteItem() {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
		personTable.getItems().remove(selectedIndex);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		personTable.setItems(mainApp.getPersonData());
	}

	private void showBookStoreDetails(Person person) {
		if (person != null) {
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			postalCodeLabel.setText(person.getPostalCode());
			cityLabel.setText(person.getCity());
			priceLabel.setText(person.getPrice());
		} else {
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			postalCodeLabel.setText("");
			cityLabel.setText("");
			priceLabel.setText("");
		}
	}

	@FXML
	private void handleDeleteBook() {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			personTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No selection");
			alert.setHeaderText("No item selected");
			alert.setContentText("Please select an item");
			alert.showAndWait();

		}
	}
// doesn't work
	@FXML
	private void handleNewPerson() {
		Person tempPerson = new Person();
		boolean okClicked = mainApp.showEditDialogue(tempPerson);
		if (okClicked) {
			mainApp.getPersonData().add(tempPerson);
		}
	}
// doesn't work
	@FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showEditDialogue(selectedPerson);
			if (okClicked) {
				showBookStoreDetails(selectedPerson);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("No selection");
				alert.setHeaderText("No item selected");
				alert.setContentText("Please select an item");
				alert.showAndWait();
			}
		}
	}
}
