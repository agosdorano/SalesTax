package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	
	private ControllerSalesTax controller;

	@Before
	public void setUp() throws Exception {
		controller = new ControllerSalesTax();
		assertNotNull(controller);
	}

	@After
	public void tearDown() throws Exception {
		controller = null;
		assertNull(controller);
	}

	@Test
	public void testFirstCase() {
		//fail("Not yet implemented");
		float oracolo = 42.32f;
		ArrayList<String> productNames = new ArrayList<String>();
		ArrayList<Float> costsInDollars = new ArrayList<Float>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<String> types = new ArrayList<String>();
		ArrayList<Boolean> importedFlags = new ArrayList<Boolean>();
		
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
		
		float result = controller.computeOrderTotal(productNames, costsInDollars, quantity, types, importedFlags);
		assertEquals(oracolo, result, 0.05);
		System.out.print("\n");
	}
	
	@Test
	public void testSecondCase() {
		//fail("Not yet implemented");
		
		float oracolo = 65.15f;
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
		
		float result = controller.computeOrderTotal(productNames, costsInDollars, quantity, types, importedFlags);
		assertEquals(oracolo, result, 0.05);
		System.out.print("\n");
	}

	@Test
	public void testThirdCase() {
		//fail("Not yet implemented");
		
		float oracolo = 98.38f;
		ArrayList<String> productNames = new ArrayList<String>();
		ArrayList<Float> costsInDollars = new ArrayList<Float>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<String> types = new ArrayList<String>();
		ArrayList<Boolean> importedFlags = new ArrayList<Boolean>();
		
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
		
		float result = controller.computeOrderTotal(productNames, costsInDollars, quantity, types, importedFlags);
		assertEquals(oracolo, result, 0.05);
		System.out.print("\n");
	}
}
