package promotionEngineTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import promotionEngine.RuleBank;

class RuleBankTest {

	RuleBank rb;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		rb=new RuleBank();
		rb.readsActiveRulesCSV("resources/activerulesbank.csv");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
		rb=new RuleBank();
	}

	@Test
	void testAssertEqualsActiveRulesSize() {
		assertEquals(rb.activeRules.size(),4); // Currently 4 Active rules in the Rule Bank.
	}

}
