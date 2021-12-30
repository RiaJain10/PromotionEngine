package promotionEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RuleBank {
	public ArrayList<Rule> activeRules;

	public RuleBank() {
	}
	
	public ArrayList<Rule> readsActiveRulesCSV(String activeRulescsvfile) throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(new File(activeRulescsvfile)))) {
		    String line;
		    br.readLine(); // Reading the First Line, so we don't pass the header in the below while loop.
		    activeRules = new ArrayList<Rule>();
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        Rule rule = new Rule();
		        rule.setId(Integer.parseInt(values[0]));
		        rule.setPromotionType(values[1]);
		        rule.setSkuid(values[2]);
		        rule.setQuantity(Integer.parseInt(values[3]));
		        rule.setPromotionPrice(Double.parseDouble(values[4]));
		        activeRules.add(rule);
		    }
		}
		return activeRules;
	}

}
