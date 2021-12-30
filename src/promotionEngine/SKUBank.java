package promotionEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SKUBank {
	
	public ArrayList<SKU> unitprices;

	public SKUBank() {
	}
	
	public ArrayList<SKU> readsUnitPriceCSV(String unitpricecsvfile) throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(new File(unitpricecsvfile)))) {
		    String line;
		    br.readLine(); // Reading the First Line, so we don't pass the header in the below while loop.
		    unitprices = new ArrayList<SKU>();
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        SKU sku = new SKU();
		        sku.setId(values[0]);
		        sku.setPrice( Double.parseDouble(values[1]));
	        	unitprices.add(sku);	
		    }
		}
		return unitprices;
	}
	
	public double getPriceById(String Id) {
		double price=0.0;
		for(SKU sku : unitprices) { 
		   if(sku.getId().equals(Id)) { 
			   price = sku.getPrice();
		   }
		}		
		return price;
	}
}