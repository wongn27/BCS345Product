package wong.bcs345.hwk.purchases.business;

/**
 * The ProductTest class performs unit tests for each method
 * <p>
 * Contains a unit test for each method
 * </p>
 * @author Natalie Wong
 * @version HW#2
 */
public class ProductTest {
	
	/**
	 * Reports pass or fail for each get/set test
	 */
	public void productTest() {
		System.out.println((productDescriptionTest()) 
				? "Product Get/Set Description: Pass" 
				: "Product Get/Set Description: Fail");
		System.out.println((productPriceTest()) 
				? "Product Get/Set Price: Pass" 
				: "Product Get/Set Price: Fail");
	}

	/**
	 * Product description test
	 * @return
	 */
	public boolean productDescriptionTest() {
		Product p = new Product();
		String testDescription = "A phone charger";

		p.setDescription(testDescription);

		return (testDescription.contentEquals(p.getDescription())
				? true 
				: false);
	}

	/**
	 * Product price test
	 * @return
	 */
	public boolean productPriceTest() {
		Product p = new Product();
		double testPrice = 5.0d;

		p.setPrice(testPrice);
		
		return (testPrice == p.getPrice()
				? true 
				: false);
	}
}
