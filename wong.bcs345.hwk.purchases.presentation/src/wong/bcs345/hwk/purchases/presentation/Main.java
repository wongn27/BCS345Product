/**
 * 
 */
package wong.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Scanner;

import wong.bcs345.hwk.purchases.business.*; // * character imports both Address and Product classes 

/**
 * @author wongn
 *
 */
public class Main {

	/**
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
		
		
		
		// Read from JSON file
		
		
		// Call to string and show the string
		
		System.out.println(a.toString());
		System.out.println(p.toString());
		// Unit testing
		
		
		
		
	}

}
