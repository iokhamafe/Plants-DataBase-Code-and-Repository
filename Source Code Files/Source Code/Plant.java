import java.util.*;
public class Plant {

	private String id;
	private String name;
	private String color;
	
	public Plant() {
		this.id = "";
		this.name = "";
		this.color = "";
	}
	
	public Plant(String plantColor, String plantID, String plantName) {
		this.id = plantID;
		this.color = plantColor;
		this.name = plantName;
	}
	
	public void setID(String plantID) {
		this.id = plantID;
	}
	
	public void setColor(String plantColor) {
		this.color = plantColor;
	}
	
	public void setName(String plantName) {
		this.name = plantName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getID() {
		return id;
	}
	
	public String toString() {
		return "This plant's name is " + this.getName() + " with a color of: " + this.getColor() +
				" with a unique ID of: " + this.getID();
	}
	
	@Override
	public boolean equals(Object otherPlant) {
		if (otherPlant == null) {
			return false;
		}
		
		if (!Plant.class.isAssignableFrom(otherPlant.getClass())) {
	        return false;
	    }
		
		final Plant other = (Plant) otherPlant;
		
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
	        return false;
	    }
	    if (!(this.color.equals(other.color))) {
	        return false;
	    }
	    
	    if (!(this.id.equals(other.id))) {
	    	return false;
	    }
	    
	    return true;
	}
	
}
