package entity;


public abstract class ItemComponentEntity {
	
	protected float costInDollar;
	
	public abstract float costInDollar();
	
	public abstract float getOriginalPrice();
	
	public abstract float getTax();
	
}
