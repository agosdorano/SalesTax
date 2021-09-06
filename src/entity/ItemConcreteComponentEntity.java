package entity;

public class ItemConcreteComponentEntity extends ItemComponentEntity{
	
	
	private String type;
	private String name;

	public ItemConcreteComponentEntity(float costInDollar, String type, String name) {
		this.costInDollar = costInDollar;
		this.type = type;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	
	public float getOriginalPrice(){
		return this.costInDollar;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public float costInDollar() {
		// TODO Auto-generated method stub
		return costInDollar;
	}

	@Override
	public float getTax() {
		// TODO Auto-generated method stub
		return 0.0f;
	}
	

}
