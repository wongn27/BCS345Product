package wong.bcs345.hwk.purchases.presentation;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import wong.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * The PurchasesController class shows the Main Display and deals with Menu
 * Event Handling
 * <p>
 * GUI event handlers are defined
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#6
 *
 */
public class PurchasesController {

	@FXML
	private PurchaseCollection purchasecollection = new PurchaseCollection();

	@FXML
	private TextField firstNameTextField;
	
	@FXML
	private TextField lastNameTextField;
	
	@FXML
	private TextField numberTextField;
	
	@FXML
	private TextField streetTextField;
	
	@FXML
	private TextField cityTextField;
	
	@FXML
	private TextField stateTextField;
	
	@FXML
	private TextField zipTextField;

	@FXML
	private MenuItem openMenuItem;

	@FXML
	private MenuItem saveAsMenuItem;

	@FXML
	private MenuItem saveReportMenuItem;

	@FXML
	private MenuItem exitMenuItem;
	
	@FXML 
	private ListView<String> listViewItems = new ListView<>();

	@FXML
	protected void populateFirstNameTextField() {
		String firstName = purchasecollection.getCustomer().getFirst();
		firstNameTextField.setText(firstName);
	}
	
	@FXML 
	protected void populateLastNameTextField() {
		String lastName = purchasecollection.getCustomer().getLast();
		lastNameTextField.setText(lastName);
	}
	
	@FXML
	protected void populateNumberTextField() {
		String number = purchasecollection.getCustomer().getAddress().getNumber();
		numberTextField.setText(number);
	}

	@FXML
	protected void populateStreetTextField() {
		String street = purchasecollection.getCustomer().getAddress().getStreet();
		streetTextField.setText(street);
	}
	
	@FXML
	protected void populateCityTextField() {
		String city = purchasecollection.getCustomer().getAddress().getCity();
		cityTextField.setText(city);
	}
	
	@FXML
	protected void populateStateTextField() {
		String state = purchasecollection.getCustomer().getAddress().getState();
		stateTextField.setText(state);
	}
	
	@FXML
	protected void populateZipTextField() {
		String zip = purchasecollection.getCustomer().getAddress().getZip();
		zipTextField.setText(zip);
	}
	
	@FXML
	protected void handleOpenMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Open PurchaseCollection File");
		filechooser.setInitialDirectory(new File ("C:\\Users\\wongn\\OneDrive\\Documents\\Java\\Hoskeyhw\\wong.bcs345.hwk.purchases.presentation"));
		File selectedFile = filechooser.showOpenDialog(new Stage());

		try {
			Scanner fileScanner = new Scanner(new FileReader(selectedFile));
			purchasecollection.Read(fileScanner);
			populateFirstNameTextField();
			populateLastNameTextField();
			populateNumberTextField();
			populateStreetTextField();
			populateCityTextField();
			populateStateTextField();
			populateZipTextField();
			
			int length = purchasecollection.getPurchaseArrayLength();
			// ObservableList
			
			for (int i = 0; i < length; i++) {
				
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}	
	}

	@FXML
	protected void handleSaveAsMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Save As PurchaseCollection");
		filechooser.setInitialDirectory(new File ("C:\\Users\\wongn\\OneDrive\\Documents\\Java\\Hoskeyhw\\wong.bcs345.hwk.purchases.presentation"));
		File fileName = filechooser.showSaveDialog(new Stage());
		
		try {
			PrintStream saveFile = new PrintStream(fileName);
			purchasecollection.Write(saveFile);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	protected void handleSaveReportMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Save PurchaseCollection Report");
		filechooser.setInitialDirectory(new File ("C:\\Users\\wongn\\OneDrive\\Documents\\Java\\Hoskeyhw\\wong.bcs345.hwk.purchases.presentation"));
		File fileName = filechooser.showSaveDialog(new Stage());

		try {
			PrintStream saveReport = new PrintStream(fileName);
			purchasecollection.Report(saveReport);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	protected void handleExitMenuItemAction(ActionEvent event) {
		Platform.exit();
	}
}
