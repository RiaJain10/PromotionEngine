package promotionEngineTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import promotionEngine.Cart;
import promotionEngine.PromotionCalc;
import promotionEngine.RuleBank;
import promotionEngine.SKUBank;

class PromotionCalcTest {
	PromotionCalc promoCalc;
	RuleBank rb;
	Cart cart;
	SKUBank skubank;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		rb=new RuleBank();
		rb.readsActiveRulesCSV("resources/activerulesbank.csv");
		skubank = new SKUBank();
		skubank.readsUnitPriceCSV("resources/unitprice.csv");
		cart=new Cart();
		promoCalc = new PromotionCalc();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
		rb=new RuleBank();
		skubank= new SKUBank();
		cart=new Cart();
		promoCalc = new PromotionCalc();
	}

	@Test
	void testAssertEqualsActiveComboRulesSize() {
		assertEquals(promoCalc.getComboRules(rb).size(),2);// Currently 2 Active Combo rules in the Rule Bank.
	}
	
	@Test
	void testAssertEqualsIsComboRuleApplicableTrue() throws FileNotFoundException, IOException {
		cart.buildCartFromCSV("resources/scenarioD.csv",skubank);
		assertEquals(promoCalc.isComboRuleApplicable(cart,promoCalc.getComboRules(rb)),true);
	}
	
	@Test
	void testAssertEqualsIsComboRuleApplicableFalse() throws FileNotFoundException, IOException {
		cart.buildCartFromCSV("resources/scenarioA.csv",skubank);
		assertEquals(promoCalc.isComboRuleApplicable(cart,promoCalc.getComboRules(rb)),false);
	}
	
	@Test
	void testAssertEqualsApplyPromotionCartA() throws FileNotFoundException, IOException {
		cart.buildCartFromCSV("resources/scenarioA.csv",skubank);
		assertEquals(promoCalc.applyPromotion(cart,rb,skubank),100);
	}
	
	@Test
	void testAssertEqualsApplyPromotionCartB() throws FileNotFoundException, IOException {
		cart.buildCartFromCSV("resources/scenarioB.csv",skubank);
		assertEquals(promoCalc.applyPromotion(cart,rb,skubank),370);
	}
	
	@Test
	void testAssertEqualsApplyPromotionCartC() throws FileNotFoundException, IOException {
		cart.buildCartFromCSV("resources/scenarioC.csv",skubank);
		assertEquals(promoCalc.applyPromotion(cart,rb,skubank),280);
	}
	
	@Test
	void testAssertEqualsApplyPromotionCartD() throws FileNotFoundException, IOException {
		cart.buildCartFromCSV("resources/scenarioD.csv",skubank);
		assertEquals(promoCalc.applyPromotion(cart,rb,skubank),205);
	}
}
