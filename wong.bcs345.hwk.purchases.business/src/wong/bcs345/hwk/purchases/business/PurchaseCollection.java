package wong.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The PurchaseCollection class contains instance members that describes an
 * customer's purchase...
 * <p>
 * Contains corresponding accessors/mutators for each member.
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#4
 */
public class PurchaseCollection {

	private Customer customer;
	private Purchase[] purchase;

	/**
	 * Default constructor Sets the values of each member variable to a default
	 * value
	 */
	public PurchaseCollection() {
		customer = new Customer();
		purchase = new Purchase[4];
		for (int i = 0; i < purchase.length; i++) {
			purchase[i] = new Purchase();
		}
	}

	/**
	 * @param c the customer to set
	 */
	public void setCustomer(Customer c) {
		this.customer = c;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Searches the array for the purchase that costs the most and returns it
	 */
	public Purchase getMaxPurchase() {
		Purchase p = purchase[0];
		double maxPurchase = purchase[0].getProduct().getPrice() * purchase[0].getQuantity();
		for (int i = 1; i < purchase.length; i++) {
			if (purchase[i].getProduct().getPrice() * purchase[i].getQuantity() > maxPurchase) {
				maxPurchase = purchase[i].getProduct().getPrice() * purchase[i].getQuantity();
				p = purchase[i];
			}
		}
		return p;
	}

	/**
	 * Returns the purchase at the given index
	 */
	public Purchase getByIndex(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > purchase.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Purchase p = purchase[index];
		return p;
	}

	/**
	 * Read the contents of all member variables from the given instance of Scanner
	 */
	public void Read(Scanner s) {
		customer.Read(s);
		System.out.println(customer.toString());
		// s.next();

		int i = s.nextInt(); // NUMBER THAT WE WANT TO LOOP, # of purchases
		System.out.println(i);

		for (int j = 0; j < i; j++) {
			purchase[j] = new Purchase();
			this.purchase[j].Read(s);
			System.out.println(this.purchase[j]);
		}

		// purchase[0] = new Purchase();
		// this.purchase[0].Read(s);

	}

	/**
	 * Write the contents of the PurchaseCollection instance to the given instance
	 * of PrintStream
	 * 
	 * @param ps
	 */
	public void Write(PrintStream ps) {
		customer.Write(ps);
		for (int i = 0; i < purchase.length; i++) {
			purchase[i].Write(ps);
		}
	}

	/**
	 * Writes a report on the given PrintStream
	 * @param ps
	 */
	public void Report(PrintStream ps) {
		ps.println("Purchase Report");
		ps.println("---------------");

		ps.printf("%-30s", "Description");
		ps.printf("%25s", "Price");
		ps.printf("%15s", "Quantity");
		ps.printf("%15s", "Cost");
		ps.printf("\n");
		ps.printf("%-30s", "-----------");
		ps.printf("%25s", "-----");
		ps.printf("%15s", "--------");
		ps.printf("%15s", "----");
		ps.printf("\n");

		for (int i = 0; i < purchase.length; i++) {
			ps.println(purchase[i].toString());

			ps.printf("%-30s", "-----------");
			ps.printf("%25s", "-----");
			ps.printf("%15s", "--------");
			ps.printf("%15s", "----");
			ps.printf("\n");
			ps.printf("%-30s", "Total");
			ps.printf("%25s", "");

			// System.out.println(purchase[1]);

		}
	}

	/**
	 * Read the contents of all member variables from the given instance of FileReader as JSON
	 * @param fr
	 */
	public void ReadJSON(FileReader fr) {
		Gson gson = new Gson();

		PurchaseCollection purchasecollection = new PurchaseCollection();
		purchasecollection = gson.fromJson(fr, PurchaseCollection.class);
		
		this.customer = purchasecollection.getCustomer();
		//this.purchase = purchasecollection.S
		//String s = purchasecollection.toString();
		//System.out.println(s);
	}
	
	/**
	 * Write the member variables in JSON format to the given PrintStream
	 * @param ps
	 */
	public void WriteJSON(PrintStream ps) {
		PurchaseCollection purchasecollection = new PurchaseCollection();
		purchasecollection.setCustomer(customer);
		//purchasecollection.purchase(purchase);
		
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString = gson.toJson(purchasecollection);
		ps.println(jsonString);  		
	}
	
	/**
	 * Displays data to the user
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < purchase.length; i++) {
			s += purchase[i].toString() + "\n";
		}
		return (customer.toString() + "\n" + s.toString());
	}
}
