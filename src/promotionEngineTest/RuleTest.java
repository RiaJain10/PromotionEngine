package promotionEngineTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import promotionEngine.Rule;

class RuleTest {
	
	Rule rule;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		rule = new Rule();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
		rule = new Rule();
	}

	@Test
	void testAssertEqualsRule1Object() {
		rule.setId(1);
		rule.setPromotionType("Single");
		rule.setPromotionPrice(130);
		rule.setQuantity(3);
		rule.setSkuid("A");
		assertEquals(rule.getId(),1);
		assertEquals(rule.getPromotionType(),"Single");
		assertEquals(rule.getPromotionPrice(),130);
		assertEquals(rule.getQuantity(),3);
		assertEquals(rule.getSkuid(),"A");
		assertEquals(rule.toString(),"Rule [id=1, promotionType=Single, skuid=A, quantity=3, promotionPrice=130.0]");
	}
}
