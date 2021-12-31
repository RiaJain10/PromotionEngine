package promotionEngineTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import promotionEngine.SKU;

 

class SKUTest {
	
	SKU sku;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		sku = new SKU();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
		sku = new SKU();
	}

	@Test
	void testAssertEqualsSkuAObject() {
		sku.setId("A");
		sku.setPrice(50);
		sku.setQuantity(1);
		assertEquals(sku.getId(),"A");
		assertEquals(sku.getPrice(),50);
		assertEquals(sku.getQuantity(),1);
		assertEquals(sku.toString(),"ID: A Price: 50.0 Quantity: 1");
	}
}
