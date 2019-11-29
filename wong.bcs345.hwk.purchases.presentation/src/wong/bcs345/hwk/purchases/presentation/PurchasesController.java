package wong.bcs345.hwk.purchases.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import wong.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * The PurchasesController class shows the Main Display and deals with Menu Event Handling
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
	protected void getCustomerData() {
		String text;
		
		// get first name
		text = purchasecollection.getCustomer().getFirst();
				
		// set first name in first name text field
		firstNameTextField.setText(text);
		
	}
	
	

}
