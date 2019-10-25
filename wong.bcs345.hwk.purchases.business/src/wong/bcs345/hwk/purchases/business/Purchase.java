package wong.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Purchase class contains instance members
 * that describes a purchase...
 * <p>
 * Contains corresponding accessors/mutators
 * for each member.
 * </p>
 * @author Natalie Wong
 * @version HW#3
 */
public class Purchase {
	
	private int quantity;
	private Product product; 

	
	/**
	 * Default constructor 
	 * Sets the values of each member variable to a reasonable default value
	 */
	public Purchase() {
		product = new Product();
		quantity = 3;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Write the contents of all member variables of the Purchase class and Product class to the given instance of PrintStream
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		product.Write(ps);
		ps.println(quantity);
	}
	
	/**
	 * Read the contents of all member variables of the Purchase class and the Product class to the given instance of Scanner
	 * @param s
	 */
	public void Read(Scanner s) {
		product.Read(s);
		quantity = s.nextInt();
	}
	
	/**
	 * Write the member variables in the Purchase class and the Product class in JSON format to the given PrintStream
	 * @param ps
	 */
	public void WriteJSON(PrintStream ps) {
		Purchase purchase = new Purchase();
		purchase.setProduct(product);
		purchase.setQuantity(quantity);
		
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString = gson.toJson(purchase);
		ps.println(jsonString);  		
	}
	
	/**
	 * Read the contents of all member variables in the Purchase class and the Product class to the given instance of Scanner as JSON
	 * @param fr
	 */
	public void ReadJSON(FileReader fr) {
		Gson gson = new Gson();
		
		Purchase purchase = gson.fromJson(fr, Purchase.class); 
		this.quantity = purchase.getQuantity();
		this.product = purchase.getProduct();
	}
	
	/**
	 * Shows descriptive text and data
	 * It will be used to display the Purchase to the user
	 */
	@Override
	public String toString() {
		return (quantity + "," + " " + product.toString());
	}
}
