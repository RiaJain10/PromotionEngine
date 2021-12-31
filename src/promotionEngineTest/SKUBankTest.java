package promotionEngineTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import promotionEngine.SKUBank;

class SKUBankTest {
	
	SKUBank skubank;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		skubank = new SKUBank();
		skubank.readsUnitPriceCSV("resources/unitprice.csv");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
		skubank = new SKUBank();
	}

	@Test
	void testAssertEqualsUnitPriceSize() {
		assertEquals(skubank.unitprices.size(),4); // Testing that the unitprices ArrayList is of size 4.
	}
	
	@Test
	void testAssertEqualsGetPriceById() {
		skubank.getPriceById("A");
		assertEquals(skubank.getPriceById("A"),50); // Testing that the price of item A is 50.	
	}
}
