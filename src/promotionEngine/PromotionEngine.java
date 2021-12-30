package promotionEngine;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PromotionEngine {
	
	public static void main(String[] args) {
		SKUBank sb = new SKUBank(); 	
		RuleBank rb = new RuleBank(); 	
		String [] fileNames = {"resources/scenarioA.csv","resources/scenarioB.csv","resources/scenarioC.csv","resources/scenarioD.csv"};
		try {
			System.out.println("Printing Unit Prices");
			sb.readsUnitPriceCSV("resources/unitprice.csv"); // Read unitprice.csv and constructing a SKU Bank.
			for(SKU sku:sb.unitprices) {
	            System.out.println(sku);
	        }
			System.out.println("Printing Active Rules");
			rb.readsActiveRulesCSV("resources/activerulesbank.csv"); // Read activerulesbank.csv and constructing a Rule Bank.
			for(Rule rule:rb.activeRules) {
	            System.out.println(rule);
	        }
			//Taking input scenarios as csv files.
			for(int i=0; i<fileNames.length; i++) {
				Cart cartScenario = new Cart();
				PromotionCalc p = new PromotionCalc();
				System.out.println("Printing " + fileNames[i] + " cart");
				cartScenario.buildCartFromCSV(fileNames[i],sb); // Building a cart for the given scenario
				for(SKU sku:cartScenario.cart) {
					System.out.println(sku);
		        }
				System.out.println("Printing Order Value Total from " + fileNames[i] + " after Applying Promotion");
				double cartTotal = p.applyPromotion(cartScenario, rb, sb); // Applying promotions & returning total order value
				System.out.println("Cart Total: "+cartTotal);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}