/**
 * 
 */
package wong.bcs345.hwk.purchases.business;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author wongn
 *
 */
public class Address {
	
	private String number;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address() {
		number = "N/A";
		street = "N/A";
		city = "N/A";
		state = "N/A";
		zip = "N/A";
	}
	
	public Address(String number, String street, String city, String state, String zip) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	public void Write(PrintStream ps) {
			ps.println(number);
			ps.println(street);
			ps.println(city);
			ps.println(state);
			ps.println(zip);		
	}
		
	public void Read(Scanner s) {		
		number = s.nextLine();
		street = s.nextLine();
		city = s.nextLine();
		state = s.nextLine();
		zip = s.nextLine();	
	}
	
	public void WriteJSON(PrintStream ps) {
		Address a = new Address();
		a.setNumber(number);
		a.setStreet(street);
		a.setCity(city);
		a.setState(state);
		a.setZip(zip);

		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();

		String jsonString = gson.toJson(a);
		ps.println(jsonString);  		
	} 
	
	public void ReadJSON(Scanner s) {
		String json = s.nextLine();
		Gson gson = new Gson();
		
		Address a = gson.fromJson(json, Address.class);
	}
	
	@Override
	public String toString() {
		String s = number + " " + street + "," + " " + city + "," + " " + state + " " + zip;
		return s;
	}
}