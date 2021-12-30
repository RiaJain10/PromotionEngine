package promotionEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cart {
	public ArrayList<SKU> cart;

	public Cart() {
	}
	
	public ArrayList<SKU> buildCartFromCSV(String scenarioCSV,SKUBank sku) throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(new File(scenarioCSV)))) {
		    String line;
		    br.readLine(); // Reading the First Line, so we don't pass the header in the below while loop.
		    cart = new ArrayList<SKU>();
		    boolean newItem = true;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        // Validating if the customer adds the same product twice in the CSV input Scenario.
		        for(int i=0; i<cart.size(); i++) {
		        	if (values[0].equals(cart.get(i).getId())){
		        		cart.get(i).setQuantity(cart.get(i).getQuantity()+Integer.parseInt(values[1]));
		        		newItem = false;
		        	}
		        }
		        if (newItem) {
		        	SKU item = new SKU();
			        item.setId(values[0]);
			        item.setQuantity(Integer.parseInt(values[1]));
			        item.setPrice(sku.getPriceById(values[0]));
			        cart.add(item);
		        }
		        newItem = true;
		    }
		}
		return cart;
	}
	
	public int getQuantityById(String Id) {
		int qty=0;
		for(SKU sku : cart) { 
		   if(sku.getId().equals(Id)) { 
			   qty = sku.getQuantity();
		   }
		}		
		return qty;
	}
}