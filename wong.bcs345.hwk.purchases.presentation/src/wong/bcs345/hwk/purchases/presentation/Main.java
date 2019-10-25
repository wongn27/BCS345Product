package wong.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import wong.bcs345.hwk.purchases.business.*; // * character imports both Address and Product classes 

/**
 * The <strong>CustomerDriver</strong> class.
 * <p>
 * Reads an input file and writes to an output file.
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#3
 * @since Sep 27, 2019
 */
public class Main {

	/**
	 * Main entry point of the program
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		CustomerPurchaseConsoleUI cpcui = new CustomerPurchaseConsoleUI();
		cpcui.ShowUI();
	}
}
