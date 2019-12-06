package wong.bcs345.hwk.purchases.presentation;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import wong.bcs345.hwk.purchases.business.Purchase;
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
	private ListView<Purchase> listViewItems = new ListView<>();

	private void populateTextField(String textFieldString, TextField textField) {
		textField.setText(textFieldString);
	}

	private void populateCustomer() {
		populateTextField(purchasecollection.getCustomer().getFirst(), firstNameTextField);
		populateTextField(purchasecollection.getCustomer().getLast(), lastNameTextField);
		populateTextField(purchasecollection.getCustomer().getAddress().getNumber(), numberTextField);
		populateTextField(purchasecollection.getCustomer().getAddress().getStreet(), streetTextField);
		populateTextField(purchasecollection.getCustomer().getAddress().getCity(), cityTextField);
		populateTextField(purchasecollection.getCustomer().getAddress().getState(), stateTextField);
		populateTextField(purchasecollection.getCustomer().getAddress().getZip(), zipTextField);
	}

	@FXML
	protected void handleOpenMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Open PurchaseCollection File");
		filechooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		File selectedFile = filechooser.showOpenDialog(new Stage());

		try {
			if (selectedFile == null) {
				return;
			}

			Scanner fileScanner = new Scanner(new FileReader(selectedFile));
			purchasecollection.Read(fileScanner);
			populateCustomer();

			int length = purchasecollection.getPurchaseArrayLength();

			ObservableList<Purchase> itemsObservableList = FXCollections.observableArrayList(); 
																								
			// clear listView
			listViewItems.getItems().clear();

			for (int index = 0; index < length; index++) {
				Purchase purchase = purchasecollection.getByIndex(index);
				itemsObservableList.add(purchase);
			}

			listViewItems.setItems(itemsObservableList);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	protected void handleSaveAsMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Save As PurchaseCollection");
		filechooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		File selectedFile = filechooser.showSaveDialog(new Stage());

		try {
			if (selectedFile == null) {
				return;
			}

			PrintStream saveFile = new PrintStream(selectedFile);
			purchasecollection.Write(saveFile);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	protected void handleSaveReportMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Save PurchaseCollection Report");
		filechooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		File selectedFile = filechooser.showSaveDialog(new Stage());

		try {
			if (selectedFile == null) {
				return;
			}

			PrintStream saveReport = new PrintStream(selectedFile);
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
