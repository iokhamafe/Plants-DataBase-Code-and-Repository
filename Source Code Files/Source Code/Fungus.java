
public class Fungus extends Plant{
	
	private boolean isPoisonous;
	
	public Fungus(String fungusColor, String fungusID, String fungusName, boolean isPoisonous) {
		super(fungusColor, fungusID, fungusName);
		this.isPoisonous = isPoisonous;
	}
	
		
	public void setIsPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
	
	public boolean getIsPoisonous(){
		return isPoisonous;
	}
	
	public String toString() {
		return "This fungus as sampled is " + this.getColor() + " in color " + " with an ID of " + this.getID() +
				" and a name of " + this.getName() + " and it's poisonous = " + this.getIsPoisonous();
	}
	
	@Override
	public boolean equals(Object otherFungus) {
		
		if (otherFungus == null) {
			return false;
		}
		if (!Fungus.class.isAssignableFrom(otherFungus.getClass())) {
			return false;
		}
		
		Fungus other = (Fungus) otherFungus;
		
		if (!(this.getColor().equals(other.getColor()))) {
			return false;
		}
		
		if (!(this.getID().equals(other.getID()))) {
			return false;
			
		}
		
		if (!(this.getName().equals(other.getName()))) {
			return false;
		}
		
		if (this.isPoisonous != other.isPoisonous) {
			return false;
		}
		
		return true;
	}
	
}
