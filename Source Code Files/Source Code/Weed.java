import java.util.*;
public class Weed extends Plant {
	private boolean isEdible, isMedicinal, isPoisonous;
	
	
	public Weed(String weedColor, String weedID, String weedName, boolean isEdible, boolean isMedicinal, boolean isPoisonous) {
		super(weedColor, weedID, weedName);
		this.isEdible = isEdible;
		this.isMedicinal = isMedicinal;
		this.isPoisonous = isPoisonous;
	}
	
	public void setIsEdible(boolean isEdible) {
		this.isEdible = isEdible;
	}
	
	public boolean getIsEdible() {
		return isEdible;
	}
	
	public void setIsMedicinal(boolean isMedicinal) {
		this.isMedicinal = isMedicinal;
	}
	
	public boolean getIsMedicinal() {
		return isMedicinal;
	}
	
	public void setIsPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
	
	public boolean getIsPoisonous() {
		return isPoisonous;
	}
	
	public String toString() {
		return "This weed is of " + this.getColor() + " color and is called " + this.getName() + 
				" with an ID of " + this.getID() + " it is edible = " + this.getIsEdible() + " and it is Poisonous " + this.getIsPoisonous() +
				" and it is medicinal " + this.getIsMedicinal();
	}
	
	@Override
	public boolean equals(Object otherWeed) {
		if (otherWeed == null) {
			return false;
		}
		
		if (!(Weed.class.isAssignableFrom(otherWeed.getClass()))) {
			return false;
		}
		
		Weed other = (Weed) otherWeed;
		
		if (!(this.getID().equals(other.getID()))) {
			return false;
		}
		
		if (!(this.getName().equals(other.getName()))) {
			return false;
		}
		
		if (!(this.getColor().equals(other.getColor()))) {
			return false;
		}
		
		if (this.isEdible != other.isEdible) {
			return false;
		}
		
		if (this.isMedicinal != other.isMedicinal) {
			return false;
		}
		
		if (this.isPoisonous != other.isPoisonous) {
			return false;
		}
		
		return true;
		
		
	}
}
