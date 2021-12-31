package promotionEngineTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import promotionEngine.Cart;
import promotionEngine.SKUBank;

class CartTest {

	Cart cart;
	SKUBank skubank;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		cart=new Cart();
		skubank = new SKUBank();
		skubank.readsUnitPriceCSV("resources/unitprice.csv");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
		cart=new Cart();
		skubank = new SKUBank();
	}

	@Test
	void testAssertEqualsCartSize() throws FileNotFoundException, IOException {
		String [] fileNames = {"resources/scenarioA.csv","resources/scenarioB.csv","resources/scenarioC.csv","resources/scenarioD.csv"};
		cart.buildCartFromCSV(fileNames[3],skubank);
		assertEquals(cart.cart.size(),4);
	}
	
	@Test
	void testAssertEqualsGetQuantityById() throws FileNotFoundException, IOException {
		String [] fileNames = {"resources/scenarioA.csv","resources/scenarioB.csv","resources/scenarioC.csv","resources/scenarioD.csv"};
		cart.buildCartFromCSV(fileNames[3],skubank);
		assertEquals(cart.getQuantityById("A"),3);
		assertEquals(cart.getQuantityById("B"),2);
		assertEquals(cart.getQuantityById("C"),1);
		assertEquals(cart.getQuantityById("D"),1);
	}
}
