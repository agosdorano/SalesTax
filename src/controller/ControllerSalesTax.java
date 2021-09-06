package controller;


import java.util.ArrayList;

import entity.BasicSalesTaxEntity;
import entity.ImportDutyTax;
import entity.ItemComponentEntity;
import entity.ItemConcreteComponentEntity;


enum NoBasicTaxItem{
	BOOK, 
	FOOD, 
	MEDICAL_PRODUCT
}


public class ControllerSalesTax {
	
	public ControllerSalesTax() {
	}
	
	public float computeOrderTotal(
			ArrayList<String> itemNames,  
			ArrayList<Float> costsInDollars,
			ArrayList<Integer> quantity,
			ArrayList<String> types,
			ArrayList<Boolean> importedFlags) {
		
		ArrayList<ItemComponentEntity> products = new ArrayList<ItemComponentEntity>();
		
		for (int i=0; i<itemNames.size();i++) {
			ItemComponentEntity simpleProduct = new ItemConcreteComponentEntity(
					costsInDollars.get(i), types.get(i), itemNames.get(i));
			if ((!types.get(i).equals(NoBasicTaxItem.BOOK.name())) 
					&& (!types.get(i).equals(NoBasicTaxItem.FOOD.name())) 
					&& (!types.get(i).equals(NoBasicTaxItem.MEDICAL_PRODUCT.name()))) {
				
				// if here the product is subject to sales tax
				simpleProduct = new BasicSalesTaxEntity(simpleProduct);
				float roundedTax = ((BasicSalesTaxEntity) simpleProduct).getTaxInDollar();
				float roundedTaxPostApproximation = (float) (Math.ceil(roundedTax*20)/20.0);
				((BasicSalesTaxEntity) simpleProduct).setTaxInDollar(roundedTaxPostApproximation);
			}
			
			if (importedFlags.get(i)) {
				// if here the product is subject to import duty tax
				simpleProduct = new ImportDutyTax(simpleProduct);
				float roundedTax = ((ImportDutyTax) simpleProduct).getTaxInDollar();
				float roundedTaxPostApproximation = (float) (Math.ceil(roundedTax*20)/20.0);
				((ImportDutyTax) simpleProduct).setTaxInDollar(roundedTaxPostApproximation);
			}
			products.add(simpleProduct);	
		}
		
		
		float totalCost = 0.0f;
		float totalTax = 0.0f;
		int i = 0;
		for (ItemComponentEntity item: products) {
			
			float totalItemCost = quantity.get(i)*item.costInDollar();	//(Math.round(item.costInDollar()*20.0)/20.0);
			float totalItemTax = quantity.get(i)*item.getTax();		//(Math.round(item.getTax()*20.0)/20.0);
			totalCost+=totalItemCost;
			totalTax+=totalItemTax;
			System.out.println(quantity.get(i)+" "+itemNames.get(i)+": "+String.format("%.2f",totalItemCost));
			i++;
			
		}
		System.out.println("Sales Taxes: "+String.format("%.2f",totalTax));
		System.out.println("Total: "+String.format("%.2f",totalCost));
		
		return totalCost;

	}
}
