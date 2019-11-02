package wong.bcs345.hwk.purchases.presentation;

import java.io.FileReader;
import java.util.Scanner;

import wong.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * The PurchaseCollectionConsoleUI class displays the user interface
 * <p>
 * Contains a ShowUI method that displays the menu and processes selections
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#4
 *
 */
public class PurchaseCollectionConsoleUI {

	/**
	 * Shows the user interface, displays the menu to the user and processes the
	 * user selections
	 */
	public void ShowUI() {
		PurchaseCollection purchasecollection = new PurchaseCollection();
		int choice;

		do {
			System.out.println("PurchaseCollection UI");
			System.out.println("---------------------");
			System.out.println("1 - Read PurchaseCollection from file");
			System.out.println("2 - Read PurchaseCollection from file as JSON");
			System.out.println("3 - Write PurchaseCollection to file");
			System.out.println("4 - Write PurchaseCollection to file as JSON");
			System.out.println("5 - Show purchase by index");
			System.out.println("6 - Show maximum purchase");
			System.out.println("7 - Show PurchaseCollection report on screen");
			System.out.println("8 - Show PurchaseCollection toString on screen");
			System.out.println("9 - Exit");
			System.out.println("Enter Choice: ");

			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				try {
					Scanner userInput = new Scanner(System.in);
					System.out.print("Enter the input filename: ");
					String fileName = userInput.nextLine();
					Scanner fileScanner = new Scanner(new FileReader(fileName));
					purchasecollection.Read(fileScanner);
				} catch (Exception e) {
					//System.out.println("Error");
					e.printStackTrace();
				}
				
				break;
			case 2: 
				
				break;
			case 3:
			}
		} while (choice != 9);
	}
}
