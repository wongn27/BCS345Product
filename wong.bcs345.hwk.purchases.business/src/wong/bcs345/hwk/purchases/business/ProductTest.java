package wong.bcs345.hwk.purchases.business;

public class ProductTest {

	public void productTest() {
		System.out.println((productDescriptionTest()) 
				? "Product Get/Set Description: Pass" 
				: "Product Get/Set Description: Fail");
		System.out.println((productPriceTest()) 
				? "Product Get/Set Price: Pass" 
				: "Product Get/Set Price: Fail");
	}

	public boolean productDescriptionTest() {
		Product p = new Product();
		String testDescription = "A phone charger";

		p.setDescription(testDescription);

		return (testDescription.contentEquals(p.getDescription())
				? true 
				: false);
	}

	public boolean productPriceTest() {
		Product p = new Product();
		double testPrice = 5.0d;

		p.setPrice(testPrice);
		
		return (testPrice == p.getPrice()
				? true 
				: false);
	}
}
