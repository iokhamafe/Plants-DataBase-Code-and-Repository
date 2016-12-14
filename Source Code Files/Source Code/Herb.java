
public class Herb extends Plant{
	private String flavor;
	private boolean isMedicinal, isSeasonal;
	
	public Herb(String herbColor, String herbID, String herbName, String flavor, boolean isMedicinal, boolean isSeasonal) {
		super(herbColor, herbID, herbName);
		this.flavor = flavor;
		this.isMedicinal = isMedicinal;
		this.isSeasonal = isSeasonal;
	}
	
	public void setHerbFlavor(String herbFlavor) {
		this.flavor = herbFlavor;
	}
	
	public String getHerbFlavor() {
		return flavor;
	}
	
	public void setMedicinalProperty(boolean isMedicinal) {
		this.isMedicinal = isMedicinal;
	}
	
	public boolean getMedicinalProperty() {
		return isMedicinal;
	}
	
	public void setSeasonalProperty(boolean isSeasonal) {
		this.isSeasonal = isSeasonal;
	}
	
	public boolean getSeasonalProperty() {
		return isSeasonal;
	}
	
	public String toString() {
		return "This herb is of " + this.getColor() + " color and is called " + this.getName() + 
				" with an ID of " + this.getID() + " with a " + this.getHerbFlavor() + " flavor and " +  " with a seasonal property of "
				+ this.getSeasonalProperty() + " and a Medicinal Property of " + this.getMedicinalProperty();
	}
	
	@Override
	public boolean equals(Object otherHerb) {
		if(otherHerb == null) {
			return false;
		}
		
		if(!Herb.class.isAssignableFrom(otherHerb.getClass())) {
			return false;
		}
		
		Herb other = (Herb) otherHerb;
		
		if (!this.flavor.equals(other.flavor)) {
			return false;
		}
		
		if (!this.getColor().equals(other.getColor())) {
			return false;
		}
		
		if (!this.getID().equals(other.getID())) {
			return false;
		}
		
		if (!this.getName().equals(other.getName())) {
			return false;
		}
		
		if (this.isMedicinal != other.isMedicinal) {
			return false;
		}
		
		if (this.isSeasonal != other.isSeasonal) {
			return false;
		}
		
		return true;
		
		
	}
}
