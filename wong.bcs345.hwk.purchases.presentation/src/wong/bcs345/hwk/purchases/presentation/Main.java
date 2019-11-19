package wong.bcs345.hwk.purchases.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

import wong.bcs345.hwk.purchases.business.*; // * character imports both Address and Product classes 

/**
 * The <strong>CustomerDriver</strong> class.
 * <p>
 * Reads an input file and writes to an output file.
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#5
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
		int choice;

		do {
			System.out.println("Choose UI");
			System.out.println("---------");
			System.out.println("1 - CustomerPurchaseConsoleUI");
			System.out.println("2 - PurchaseCollectionConsoleUI");
			System.out.println("3 - Exit");
			System.out.println("Enter Choice: ");

			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				CustomerPurchaseConsoleUI cpcui = new CustomerPurchaseConsoleUI();
				cpcui.ShowUI();
				break;
			case 2:
				PurchaseCollectionConsoleUI pccui = new PurchaseCollectionConsoleUI();
				pccui.ShowUI();
				break;
			}
		} while (choice != 3);
	}
}
