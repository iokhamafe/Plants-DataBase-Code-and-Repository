
public class Flower extends Plant {
	private boolean hasThorns;
	private String smell;
	
	public Flower(String flowerColor, String flowerID, String flowerName, String smell, boolean hasThorns) {
		super(flowerColor, flowerID, flowerName);
		this.hasThorns = hasThorns;
		this.smell = smell;
	}
	
	public void setSmell(String flowerSmell) {
		this.smell = flowerSmell;
	}
	
	public void setThorns(boolean isThorny) {
		this.hasThorns = isThorny;
	}
	
	
	public String getSmell() {
		return smell;
	}
		
	public boolean getIsThorny() {
		return hasThorns;
	}
	
	public String toString() {
		return "This flower is colored: " + super.getColor() + " with a name of " + super.getName() + 
				" and an ID of " + super.getID() + " the smell is " + this.smell + " and it is thorny = " + this.hasThorns;
	}
	
	@Override
	public boolean equals(Object otherFlower) {
		if (otherFlower == null) {
			return false;
		}
		
		if (!Flower.class.isAssignableFrom(otherFlower.getClass())) {
			return false;
		}
		
		Flower other = (Flower) otherFlower;
		if (!(this.getName().equals(other.getName()))) {
			return false;
		}
		
		if (!(this.getColor().equals(other.getColor()))) {
			return false;
		}
		
		if ((this.getSmell() != (other.getSmell()))) {
			return false;
		}
		
		if (!(this.getID().equals(other.getID()))) {
			return false;
		}
		
		if(this.getIsThorny() != other.getIsThorny()) {
			return false;
		}
		
		return true;
	}
}
