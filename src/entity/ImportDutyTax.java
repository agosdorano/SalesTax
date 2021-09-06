package entity;

public class ImportDutyTax extends TaxDecoratorEntity{
	
	private static final float DUTY_TAX_PERCENTAGE = 0.05f;
	private float taxInDollar;
	
	
	public float getTaxInDollar() {
		return taxInDollar;
	}

	public void setTaxInDollar(float taxInDollar) {
		this.taxInDollar = taxInDollar;
	}

	public ImportDutyTax(ItemComponentEntity item) {
		this.itemComponent = item;
		// computation of tax WITH itemComponent
		this.taxInDollar = getOriginalPrice() * DUTY_TAX_PERCENTAGE; 
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
