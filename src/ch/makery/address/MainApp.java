package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.BookStoreViewController;
import ch.makery.address.view.EditDialogueController;
<<<<<<< HEAD
import ch.makery.address.view.RegisterController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public MainApp() {

		personData.add(new Person("Adnan Aziz", "Algorithms"));
		personData.add(new Person("Shawn T O'neil", "Bioinformatics"));
		personData.add(new Person("Thomas Mailund", "Compilers"));
		personData.add(new Person("Dr Kung-Hua Chang", "Data Structures"));
		personData.add(new Person("Kishori Sharan", "Java"));
		personData.add(new Person("Davis Sawyer", "HTML/CSS"));
		personData.add(new Person("Andreas C Muller", "Machine Learning"));
		personData.add(new Person("C.S. Calude", "Automata"));
		personData.add(new Person("AL Sweigart", "Automate the boring stuff with Python"));
		personData.add(new Person("Mark Newman", "Networks"));
		personData.add(new Person("Cory Althoff", "The Self Taught Programmer"));
		personData.add(new Person("Robert C Martin", "Clean Code"));

	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AlphaSquad Shop");
		//showRegistrationPage();
		initRootLayout();
		showPersonOverview();
	}

	// trying to make showReigstrationPage run first
	public void showRegistrationPage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/Registration.fxml"));
		RegisterController controller = loader.getController();
		AnchorPane page = (AnchorPane) loader.load();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setHeight(580);
			primaryStage.setWidth(820);
=======
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public MainApp() {

		personData.add(new Person("Adnan Aziz", "Algorithms"));
		personData.add(new Person("Shawn T O'neil", "Bioinformatics"));
		personData.add(new Person("Thomas Mailund", "Compilers"));
		personData.add(new Person("Dr Kung-Hua Chang", "Data Structures"));
		personData.add(new Person("Kishori Sharan", "Java"));
		personData.add(new Person("Davis Sawyer", "HTML/CSS"));
		personData.add(new Person("Andreas C Muller", "Machine Learning"));
		personData.add(new Person("C.S. Calude", "Automata"));
		personData.add(new Person("AL Sweigart", "Automate the boring stuff with Python"));
		personData.add(new Person("Mark Newman", "Networks"));
		personData.add(new Person("Cory Althoff", "The Self Taught Programmer"));
		personData.add(new Person("Robert C Martin", "Clean Code"));
		

	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AlphaSquad Shop");
		initRootLayout();
		showPersonOverview();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
>>>>>>> branch 'master' of https://github.com/svyas2/Home.git
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPersonOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BookStore.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(personOverview);
			BookStoreViewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public boolean showEditDialogue(Person person) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EditDialogue.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogueStage = new Stage();
			dialogueStage.setTitle("Edit item");
			dialogueStage.initModality(Modality.WINDOW_MODAL);
			dialogueStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogueStage.setScene(scene);

			EditDialogueController Controller = loader.getController();
			Controller.setDialogueStage(dialogueStage);
			Controller.setPerson(person);
			dialogueStage.showAndWait();
			return Controller.isOKClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}