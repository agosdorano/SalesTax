package entity;

public class BasicSalesTaxEntity extends TaxDecoratorEntity{
	
	private static final float SALES_TAX_PERCENTAGE = 0.10f;
	private float taxInDollar;
	
	
	
	public float getTaxInDollar() {
		return taxInDollar;
	}

	public void setTaxInDollar(float taxInDollar) {
		this.taxInDollar = taxInDollar;
	}

	public BasicSalesTaxEntity(ItemComponentEntity item) {
		this.itemComponent = item;
		this.taxInDollar = getOriginalPrice() * SALES_TAX_PERCENTAGE;
		//this.taxInDollar = Math.round(this.taxInDollar * 20.0) / 20.0;
		
	}

	@Override
	public float costInDollar() {
		// TODO Auto-generated method stub
		return this.itemComponent.costInDollar() + this.taxInDollar;
	}

	@Override
	public float getOriginalPrice() {
		// TODO Auto-generated method stub
		return itemComponent.getOriginalPrice();
	}

	@Override
	public float getTax() {
		// TODO Auto-generated method stub
		return this.taxInDollar+this.itemComponent.getTax();
	}
	

}
