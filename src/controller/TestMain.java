package controller;

import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControllerSalesTax controller = new ControllerSalesTax();
		
		
		ArrayList<String> productNames = new ArrayList<String>();
		ArrayList<Float> costsInDollars = new ArrayList<Float>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<String> types = new ArrayList<String>();
		ArrayList<Boolean> importedFlags = new ArrayList<Boolean>();
		
		productNames.add("imported box of chocolate");
		productNames.add("imported bottle of perfume");
		
		costsInDollars.add(10.00f);
		costsInDollars.add(47.50f);
		
		quantity.add(1);
		quantity.add(1);
		
		types.add("FOOD");
		types.add("OTHERS");
		
		importedFlags.add(true);
		importedFlags.add(true);
		
		controller.computeOrderTotal(productNames, costsInDollars, quantity, types, importedFlags);
		System.out.print("\n");
		
		productNames = new ArrayList<String>();
		costsInDollars = new ArrayList<Float>();
		quantity = new ArrayList<Integer>();
		types = new ArrayList<String>();
		importedFlags = new ArrayList<Boolean>();
		
		productNames.add("book");
		productNames.add("music CD");
		productNames.add("chocolate bar");
		
		costsInDollars.add(12.49f);
		costsInDollars.add(14.99f);
		costsInDollars.add(0.85f);
		
		quantity.add(2);
		quantity.add(1);
		quantity.add(1);
		
		types.add("BOOK");
		types.add("OTHERS");
		types.add("FOOD");
		
		importedFlags.add(false);
		importedFlags.add(false);
		importedFlags.add(false);
		
		controller.computeOrderTotal(productNames, costsInDollars, quantity, types, importedFlags);
		System.out.print("\n");
		
		productNames = new ArrayList<String>();
		costsInDollars = new ArrayList<Float>();
		quantity = new ArrayList<Integer>();
		types = new ArrayList<String>();
		importedFlags = new ArrayList<Boolean>();
		
		productNames.add("imported bottle of perfume");
		productNames.add("bottle of perfume");
		productNames.add("packet of headache pills");
		productNames.add("box of imported chocolates");
		
		costsInDollars.add(27.99f);
		costsInDollars.add(18.99f);
		costsInDollars.add(9.75f);
		costsInDollars.add(11.25f);
		
		quantity.add(1);
		quantity.add(1);
		quantity.add(1);
		quantity.add(3);
		
		types.add("OTHERS");
		types.add("OTHERS");
		types.add("MEDICAL_PRODUCT");
		types.add("FOOD");
		
		importedFlags.add(true);
		importedFlags.add(false);
		importedFlags.add(false);
		importedFlags.add(true);
		
		controller.computeOrderTotal(productNames, costsInDollars, quantity, types, importedFlags);
		

	}

}
