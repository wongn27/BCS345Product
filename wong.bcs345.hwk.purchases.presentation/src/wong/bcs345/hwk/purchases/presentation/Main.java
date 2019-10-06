package wong.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Scanner;

import wong.bcs345.hwk.purchases.business.*; // * character imports both Address and Product classes 

/**
 * The <strong>CustomerDriver</strong> class.
 * <p>
 * Reads an input file and writes to an output file.
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#2
 * @since Sep 27, 2019
 */
public class Main {

	/**
	 * Main entry point of the program
	 * @param args
	 */
	public static void main(String[] args) {
		
		Address a;
		a = new Address();
		a.setNumber("10");
		a.setStreet("Maple");
		a.setCity("New York");
		a.setState("NY");
		a.setZip("12345");
		
		Product p;
		p = new Product();
		p.setDescription("Charger");
		p.setPrice(5.00);
		
		// Write to file
		PrintStream ps;
		try {
			ps = new PrintStream("out");
			a.Write(ps);
			p.Write(ps);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Read in from file
		Scanner s;
		try {
			s = new Scanner(new FileReader("out"));
			a.Read(s);
			p.Read(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		// Write to JSON file
		try {
			PrintStream printStream = new PrintStream("out");
			a.WriteJSON(printStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Read from JSON file
		try {
			Scanner scanner = new Scanner(new FileReader("out"));
			a.ReadJSON(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Call toString and show the string	
		System.out.println(a.toString());
		System.out.println(p.toString());
		
		// Unit Testing
		AddressTest addressTest;
		addressTest = new AddressTest();
		addressTest.addressTest();
		
		ProductTest productTest;
		productTest = new ProductTest();
		productTest.productTest();	
		
	}

}