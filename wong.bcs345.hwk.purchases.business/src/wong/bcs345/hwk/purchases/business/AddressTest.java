/**
 * 
 */
package wong.bcs345.hwk.purchases.business;

/**
 * @author wongn
 *
 */
public class AddressTest {

	/**
	 * Reports pass or fail for each get/set test.
	 */
	public void addressTest() {
		System.out.println((addressNumberTest()) 
				? "Address Get/Set Number: Pass" 
				: "Address Get/Set Number: Fail");
		System.out.println((addressStreetTest()) 
				? "Address Get/Set Street: Pass" 
				: "Address Get/Set Street: Fail");
		System.out.println((addressCityTest()) 
				? "Address Get/Set City: Pass" 
				: "Address Get/Set City: Fail");
		System.out.println((addressStateTest()) 
				? "Address Get/Set State: Pass" 
				: "Address Get/Set State: Fail");
		System.out.println((addressZipTest()) 
				? "Address Get/Set Zip: Pass" 
				: "Address Get/Set Zip: Fail");
	}
	
	/**
	 * Address number test
	 * @return
	 */
	public boolean addressNumberTest() {
		Address a = new Address();
		String testNumber = "10";
		
		a.setNumber(testNumber);
	
		return (testNumber.contentEquals(a.getNumber())
				? true 
				: false);
	}
	
	public boolean addressStreetTest() {
		Address a = new Address();
		String testStreet = "Maple";
		
		a.setStreet(testStreet);
		
		return (testStreet.contentEquals(a.getStreet())
				? true 
				: false);
	}
	
	public boolean addressCityTest() {
		Address a = new Address();
		String testCity = "New York";
		
		a.setCity(testCity);
		
		return (testCity.contentEquals(a.getCity())
				? true 
				: false);
	}
	
	public boolean addressStateTest() {
		Address a = new Address();
		String testState = "NY";
		
		a.setState(testState);
		
		return (testState.contentEquals(a.getState())
				? true 
				: false);
	}
	
	public boolean addressZipTest() {
		Address a = new Address();
		String testZip = "10";
		
		a.setZip(testZip);
		
		return (testZip.contentEquals(a.getZip())) 
				? true
				: false;
			
	}
}