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
	private PurchaseCollection purchasecollection;

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
		String text;

		// get first name
		text = purchasecollection.getCustomer().getFirst();

		// set first name in first name text field
		firstNameTextField.setText(text);

	}

	@FXML
	private void handleOpenMenuItemAction(ActionEvent event) {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Open PurchaseCollection File");
		filechooser.showOpenDialog(new Stage());

		JFileChooser chooser = new JFileChooser();
		// int returnValue = chooser.showOpenDialog(null);
		// User chose Open
		// if (JFileChooser.APPROVE_OPTION) {
		try {
			String file = filechooser.getInitialFileName();
			Scanner fileScanner = new Scanner(new FileReader(file));
			purchasecollection.Read(fileScanner);
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
