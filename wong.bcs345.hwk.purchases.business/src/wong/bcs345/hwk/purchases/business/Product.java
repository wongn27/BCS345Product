/**
 * 
 */
package wong.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author wongn
 *
 */
public class Product {

	private String description;
	private double price;
	
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
	
	public void Write(PrintStream ps) {
		ps.println(description);
		ps.println(price);
	}
	
	public void Read(Scanner s) {
		description = s.nextLine();
		price = s.nextDouble();
	}
	
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
	
	public void ReadJSON(Scanner s) {
		
	}
	
	@Override
	public String toString() {
		String s = String.format("%s, $%.2f", description, price);
		return s;
	}
}