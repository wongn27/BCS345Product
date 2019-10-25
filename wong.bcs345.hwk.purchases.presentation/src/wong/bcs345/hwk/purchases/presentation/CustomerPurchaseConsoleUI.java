package wong.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import wong.bcs345.hwk.purchases.business.Customer;
import wong.bcs345.hwk.purchases.business.Purchase;

/**
 * The CustomerPurchaseConsoleUI class displays the user interface
 * <p>
 * Contains a ShowUI method that displays the menu and processes selections
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#3
 */
public class CustomerPurchaseConsoleUI {

	/**
	 * Shows the user interface Displays the menu to the user Processes the user
	 * selections
	 */
	public void ShowUI() {
		Customer customer = new Customer();
		Purchase purchase = new Purchase();
		int choice;

		do {
			System.out.println("Customer/Purchase UI");
			System.out.println("--------------------");
			System.out.println("1 - Read customer from file");
			System.out.println("2 - Read customer from file as JSON");
			System.out.println("3 - Write customer to file");
			System.out.println("4 - Write customer to file as JSON");
			System.out.println("5 - Show customer info on screen");
			System.out.println("6 - Read purchase from file");
			System.out.println("7 - Read purchase from file as JSON");
			System.out.println("8 - Write purchase to file");
			System.out.println("9 - Write purchase to file as JSON");
			System.out.println("10 - Show purchase info on screen");
			System.out.println("11 - Exit");
			System.out.print("Enter Choice: ");

			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				try {
					String fileName;
					Scanner userInput = new Scanner(System.in);
					Scanner fileScanner;
					System.out.print("Enter the input filename: ");
					fileName = userInput.nextLine();
					fileScanner = new Scanner(new FileReader(fileName));
					customer.Read(fileScanner);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			case 2:
				try {
					String fileName = null;
					Scanner userInput = new Scanner(System.in);
					System.out.print("Enter the input filename: ");
					fileName = userInput.nextLine();
					FileReader reader = new FileReader(fileName);
					customer.ReadJSON(reader);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			case 3:
				try {
					String outputFile;
					Scanner userInput = new Scanner(System.in);
					PrintStream writeToFile;
					System.out.print("Enter the output filename: ");
					outputFile = userInput.nextLine();
					writeToFile = new PrintStream(outputFile);
					customer.Write(writeToFile);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			case 4:
				try {
					String outputFile;
					Scanner userInput = new Scanner(System.in);
					PrintStream writeToFile;
					System.out.print("Enter the output filename: ");
					outputFile = userInput.nextLine();
					writeToFile = new PrintStream(outputFile);
					customer.WriteJSON(writeToFile);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			case 5:
				String s;
				s = customer.toString();
				System.out.println(s);
				break;

			case 6:
				try {
					String fileName;
					Scanner userInput = new Scanner(System.in);
					Scanner fileScanner;
					System.out.print("Enter the input filename: ");
					fileName = userInput.nextLine();
					fileScanner = new Scanner(new FileReader(fileName));
					purchase.Read(fileScanner);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;

			case 7:
				try {
					String fileName = null;
					Scanner userInput = new Scanner(System.in);
					System.out.print("Enter the input filename: ");
					fileName = userInput.nextLine();
					FileReader reader = new FileReader(fileName);
					purchase.ReadJSON(reader);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;

			case 8:
				try {
					String outputFile;
					Scanner userInput = new Scanner(System.in);
					PrintStream writeToFile;
					System.out.print("Enter the output filename: ");
					outputFile = userInput.nextLine();
					writeToFile = new PrintStream(outputFile);
					purchase.Write(writeToFile);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;

			case 9:
				try {
					String outputFile;
					Scanner userInput = new Scanner(System.in);
					PrintStream writeToFile;
					System.out.print("Enter the output filename: ");
					outputFile = userInput.nextLine();
					writeToFile = new PrintStream(outputFile);
					purchase.WriteJSON(writeToFile);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;

			case 10:
				System.out.println(purchase.toString());
				break;
			}

		} while (choice != 11);
	}
}
