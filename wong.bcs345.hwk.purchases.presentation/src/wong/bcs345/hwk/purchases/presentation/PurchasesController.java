package wong.bcs345.hwk.purchases.presentation;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	private MenuItem openMenuItem;

	@FXML
	private MenuItem saveAsMenuItem;

	@FXML
	private MenuItem saveReportMenuItem;

	@FXML
	private MenuItem exitMenuItem;

	@FXML
	protected void getCustomerData() {
		// get first name
		String text = purchasecollection.getCustomer().getFirst();

		// set first name in first name text field
		firstNameTextField.setText(text);
	}

	@FXML
	private void handleOpenMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Open PurchaseCollection File");
		filechooser.setInitialDirectory(new File ("C:\\Users\\wongn\\OneDrive\\Documents\\Java\\Hoskeyhw\\wong.bcs345.hwk.purchases.presentation"));
		File selectedFile = filechooser.showOpenDialog(new Stage());

		try {
			Scanner fileScanner = new Scanner(new FileReader(selectedFile));
			purchasecollection.Read(fileScanner);
			getCustomerData();
		} catch (Exception exception) {
			exception.printStackTrace();
		}	
	}

	@FXML
	private void handleSaveAsMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Save As PurchaseCollection");
		filechooser.showSaveDialog(new Stage());

	}

	@FXML
	private void handleSaveReportMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Save PurchaseCollection Report");
		filechooser.showSaveDialog(new Stage());

	}

	@FXML
	private void handleExitMenuItemAction(ActionEvent event) {
		Platform.exit();
	}
}
