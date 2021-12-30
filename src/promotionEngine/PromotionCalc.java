package promotionEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PromotionCalc {
	public double orderTotal = 0;
	public PromotionCalc() {
	}
	
	//This method returns all the combo rules from the rule bank.
	public ArrayList<Rule> getComboRules(RuleBank rules){ 
		ArrayList<Rule> activeRulesCombo = new ArrayList<Rule>();
		for(int j = 0; j< rules.activeRules.size(); j++) {
			if(rules.activeRules.get(j).getPromotionType().equals("Combo")) {
				activeRulesCombo.add(rules.activeRules.get(j));
			}
		}
		return activeRulesCombo;
	}
	
	//This method checks if combo rule is applicable by comparing cart and activeComboRules
	public boolean isComboRuleApplicable(Cart cart, ArrayList<Rule> activeComboRules) {
		
		boolean comboRulesApplyToCart = false; 
		Map<String, Integer> cartMap = new HashMap<>(); 
		Map<String, Integer> activeComboRulesMap = new HashMap<>(); 
		//Holding product id and quantity in cart as a map
		for(int i = 0; i < cart.cart.size(); i++) {
			cartMap.put(cart.cart.get(i).getId(),cart.cart.get(i).getQuantity());
		}
		//Holding product id and quantity in combo rules as a map
		for(int i = 0; i < activeComboRules.size(); i++) {
			activeComboRulesMap.put(activeComboRules.get(i).getSkuid(),activeComboRules.get(i).getQuantity());
		}
		//compares above two maps to check if rule set is subset to cart set.
		comboRulesApplyToCart = cartMap.entrySet().containsAll(activeComboRulesMap.entrySet());
		return comboRulesApplyToCart;
	}
	
	public double applyPromotion(Cart cart, RuleBank rules, SKUBank sku){
		ArrayList<Rule> activeRulesList = new ArrayList<Rule>();
		ArrayList<Rule> activeComboRulesList = getComboRules(rules);
		Map<String, ArrayList<Rule> > map = new HashMap<>();

		//Iterating through each product of the cart to check if any promotion applies to it  
		
		for (int i = 0; i < cart.cart.size(); i++) {
			//Iterating through each rule of the rule bank to check if that rule applies to the current product
			for(int j = 0; j< rules.activeRules.size(); j++) {
				//To check single promotion is applicable checking promotion type,quantity and product id
				 if (cart.cart.get(i).getId().equals(rules.activeRules.get(j).getSkuid()) &&
					(cart.cart.get(i).getQuantity() >= rules.activeRules.get(j).getQuantity() 
					&& rules.activeRules.get(j).getPromotionType().equals("Single") ) ) {
					//selecting the single rule as applicable and adding to active rules list
				    activeRulesList.add(rules.activeRules.get(j));
				 }
				//To check combo promotion is applicable checking promotion type,quantity,product id
				 else if (cart.cart.get(i).getId().equals(rules.activeRules.get(j).getSkuid()) &&
						 (cart.cart.get(i).getQuantity() >= rules.activeRules.get(j).getQuantity() 
						 && rules.activeRules.get(j).getPromotionType().equals("Combo") &&
						 isComboRuleApplicable(cart, activeComboRulesList)) ) {
					//selecting the combo rule as applicable and adding to active rules list
					activeRulesList.add(rules.activeRules.get(j));
				 }
				 else {
					;
				 }
			}
			//holding the product and rules applicable on it in a map to apply it later on.
			map.put(cart.cart.get(i).getId(), activeRulesList);
			//resetting the list to hold the rules for the next product in the cart
			activeRulesList = new ArrayList<Rule>();
		}
		
		//applying the promotions to calculate the order total
		if (map.size()>0) {
			HashSet<Integer> ruleId = new HashSet<>();
			//Iterating through the map to calculate the price per product
			for (String key : map.keySet()) {
				//checking if any rule is applicable to the product then applying it
				if(map.get(key).size()>0){
					for(Rule r: map.get(key)) {
						//Applying the single promotion on the product 
						if (r.getPromotionType().equals("Single")){
							orderTotal = orderTotal + ((cart.getQuantityById(key) % r.getQuantity()) * sku.getPriceById(key))
										 + ((cart.getQuantityById(key) / r.getQuantity()) * r.getPromotionPrice());
						}
						//Applying the combo promotion on the product
						else if(r.getPromotionType().equals("Combo")) {
							//To ensure combo price is added only once to the order total
							if (!(ruleId.contains(r.getId()))) {
								orderTotal = orderTotal + r.getPromotionPrice();
							}
							ruleId.add(r.getId());
						}
					}
				}
				//No rule is applicable to the product so calculating its price by unit price * quantity
				else {
					double price = sku.getPriceById(key);
					int qty = cart.getQuantityById(key);
					orderTotal += (price * qty);
				}
		    }
		}
		
		return orderTotal;
	}
}
