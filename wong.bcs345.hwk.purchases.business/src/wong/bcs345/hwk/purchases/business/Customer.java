package wong.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Customer class contains instance members
 * that describes a customer...
 * <p>
 * Contains corresponding accessors/mutators
 * for each member.
 * </p>
 * @author Natalie Wong
 * @version HW#3
 */
public class Customer {
	
	private String first;
	private String last;
	private Address address;
	
	/**
	 * Default constructor
	 * Sets the values of each member variable to a default value
	 */
	public Customer() {
		first = "N/A";
		last = "N/A";
		address = new Address();
	}

	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Write the contents of all member variables of the Customer class and Address class to the given instance of PrintStream
	 * @param ps
	 */
	public void Write(PrintStream ps) {
			ps.println(first);
			ps.println(last);
			address.Write(ps);		
	}
		
	/**
	 * Read the contents of all member variables of the Customer class and the Address class to the given instance of Scanner
	 * @param s
	 */
	public void Read(Scanner s) {		
		first = s.nextLine();
		last = s.nextLine();
		address.Read(s);
		
	}
	
	/**
	 * Write the member variables in the Customer class and the Address class in JSON format to the given PrintStream
	 * @param ps
	 */
	public void WriteJSON(PrintStream ps) {
		Customer customer = new Customer();
		customer.setFirst(first);
		customer.setLast(last);
		customer.setAddress(address);
		
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString = gson.toJson(customer);
		ps.println(jsonString);  		
	} 
	
	/**
	 * Read the contents of all member variables in the Customer class and the Address class to the given instance of Scanner as JSON
	 * @param fr
	 */
	public void ReadJSON(FileReader fr) {
		Gson gson = new Gson();
		
		Customer customer = new Customer();
		customer = gson.fromJson(fr, Customer.class); 
		
		this.first = customer.getFirst();
		this.last = customer.getLast();
		this.address = customer.getAddress();
	}
	
	/**
	 * Shows descriptive text and data
	 * It will be used to display the full name and address to the user
	 */
	@Override
	public String toString() {
		return (first + " " + last + "\n" + address.toString());
	}
}
