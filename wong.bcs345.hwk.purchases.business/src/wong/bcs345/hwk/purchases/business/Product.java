package wong.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Product class contains instance members
 * that describes an product...
 * <p>
 * Contains corresponding accessors/mutators
 * for each member.
 * </p>
 * @author Natalie Wong
 * @version HW#3
 */
public class Product {

	private String description;
	private double price;
	
	/**
	 * Default constructor 
	 * Sets the values of each member variable to a reasonable default value
	 */
	public Product() {
		description = "N/A";
		price = 0.00;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Write the contents of all member variables to the given instance of PrintStream
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		ps.println(description);
		ps.println(price);
	}
	
	/**
	 * Read the contents of all member variables from the given instance of Scanner
	 * @param s
	 */
	public void Read(Scanner s) {
		description = s.nextLine();
		price = s.nextDouble();
	}
	
	/**
	 * Write the member variables in JSON format to the given PrintStream
	 * @param ps
	 */
	public void WriteJSON(PrintStream ps) {
		Product p = new Product();
		p.setDescription(description);
		p.setPrice(price);
		
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString = gson.toJson(p);
		ps.println(jsonString);  		
	}
	
	/**
	 * Read the contents of all member variables from the given instance of Scanner as JSON
	 * @param s
	 */
	public void ReadJSON(FileReader fr) { 
		Gson gson = new Gson();
		
		Product p = gson.fromJson(fr, Product.class); 
		this.description = p.getDescription();
		this.price = p.getPrice();
	}
	
	/**
	 * Shows descriptive text and data
	 * It will be used to display an address to the user
	 */
	@Override
	public String toString() {
		String s = String.format("%s, $%.2f", description, price);
		return s;
	}
}
