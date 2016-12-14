import java.util.*;
import java.io.*;

public class PlantDriverCommandLine {
	public static void main(String[] args) throws IOException {
		new PlantDriverMidTerm();
	}
	
	public PlantDriverMidTerm() throws IOException {
		Scanner input = new Scanner(System.in);
		ArrayList<Plant> plantPack = new ArrayList<Plant>();

		System.out.println("Welcome to my Plant pack interface.");
		System.out.println("Please select a number from the options below");
		System.out.println("");

		while (true) {
			// Give the user a list of their options
			System.out.println("1: Add a plant item to the pack."); 
			System.out.println("2: Add a flower item to the pack."); 
			System.out.println("3: Add a fungus item to the pack."); 
			System.out.println("4: Add a weed item to the pack."); 
			System.out.println("5: Remove a plant item (regardless of its type)from the pack.");
			
			System.out.println("6: Search for a plant by name.");
			
			System.out.println("7: Display the plants in the pack."); 
			System.out.println("8: Filter plant pack by incomplete name"); 
			System.out.println("9: Print Plants from the pack to a file!");
			System.out.println("10: Read Plants from a file that is already created and output them");
			System.out.println("0: Exit the flower pack interface.");

			// Get the user input
			int userChoice = input.nextInt();

			switch (userChoice) {
			case 1:
				addPlant(plantPack);
				break;
			case 2:
				addFlower(plantPack);
				break;
			case 3:
				addFungus(plantPack);
				break;
			case 4:
				addWeed(plantPack);
				break;
			case 5:
				removePlant(plantPack);
				break;
			
			case 6:
				searchPlants(plantPack);
				break;
			case 7:
				displayPlants(plantPack);
				break;
			case 8:
				filterPlants(plantPack);
				break;
			case 9:
				savePlantsToFile(plantPack);
				break;
			case 10:
				readPlantsFromFile();
				break;
			case 0:
				System.out.println("Thank you for using the plant pack interface. See you again soon!");
				System.exit(0);
			}
		}

	}
	
	private void addPlant(ArrayList<Plant> plantPack) {
		//Add a plant that is specified by the user
		String plantName;
		String plantColor;
		String plantID;
		
        Scanner plantInput = new Scanner(System.in);
         
        System.out.println("Please enter the name of a plant type to add:");
        
        plantName = plantInput.nextLine();
        System.out.println("What is the color of the plant you would like to add?: ");
        plantColor = plantInput.nextLine();
        System.out.println("What is the ID of the plant?: ");
        plantID = plantInput.nextLine();
        
       
        
        Plant thePlant = new Plant(plantColor, plantID, plantName);
        plantPack.add(thePlant);

	}
	
	private void addFlower(ArrayList<Plant> plantPack) {
		//Add a plant that is specified by the user
		String flowerName;
		String flowerColor;
		String flowerID;
		String scentType;
		String isItThorny;
		boolean isThorny;
		
        Scanner flowerInput = new Scanner(System.in);
         
        System.out.println("Please enter the name of a flower type to add:");
        
        flowerName = flowerInput.nextLine();
        System.out.println("What is the color of the flower you would like to add?: ");
        flowerColor = flowerInput.nextLine();
        System.out.println("What is the ID of the flower?: ");
        flowerID = flowerInput.nextLine();
        System.out.println("Is the flower a thorny kind of flower? (Please answer yes or no with y or n only");
        isItThorny = flowerInput.nextLine();
        if (isItThorny.equalsIgnoreCase("y")) {
        	isThorny = true;
        } else {
        	isThorny = false;
        }
        System.out.println("Please describe the scent of the flower: ");
        scentType = flowerInput.nextLine();
        Flower theFlower = new Flower(flowerColor, flowerID, flowerName, scentType, isThorny);
        plantPack.add(theFlower);

	}
	
	private void addFungus(ArrayList<Plant> plantPack) {
		//Add a plant that is specified by the user
		String fungusName;
		String fungusColor;
		String fungusID;
		String isItPoisnous;
		boolean isPoisonous;
		
        Scanner fungusInput = new Scanner(System.in);
         
        System.out.println("Please enter the name of a fungus type to add:");
        
        fungusName = fungusInput.nextLine();
        System.out.println("What is the color of the fungus you would like to add?: ");
        fungusColor = fungusInput.nextLine();
        System.out.println("What is the ID of the fungus?: ");
        fungusID = fungusInput.nextLine();
        System.out.println("Is the fungus a poisonous kind of fungus? (Please answer yes or no with y or n only");
        isItPoisnous = fungusInput.nextLine();
        
        if (isItPoisnous.equalsIgnoreCase("y")) {
        	isPoisonous = true;
        } else {
        	isPoisonous = false;
        }
        
        Fungus newFungus = new Fungus(fungusColor, fungusID, fungusName, isPoisonous);
        plantPack.add(newFungus);

	}
	
	private void addWeed(ArrayList<Plant> plantPack) {
		//Add a plant that is specified by the user
		String weedName;
		String weedColor;
		String weedID;
		String isItEdible;
		boolean isEdible;
		String isItMedicinal;
		boolean isMedicinal;
		String isItPoisnous;
		boolean isPoisonous;
		
        Scanner weedInput = new Scanner(System.in);
         
        System.out.println("Please enter the name of a weed type to add:");
        
        weedName = weedInput.nextLine();
        System.out.println("What is the color of the weed you would like to add?: ");
        weedColor = weedInput.nextLine();
        System.out.println("What is the ID of the weed?: ");
        weedID = weedInput.nextLine();
        System.out.println("Is the weed an edible kind of weed? (Please answer yes or no with y or n only");
        isItEdible = weedInput.nextLine();
        
        if (isItEdible.equalsIgnoreCase("y")) {
        	isEdible = true;
        } else {
        	isEdible = false;
        }
       
        System.out.println("Is the weed a medicinal kind of weed? (Please answer yes or no with y or n only");
        isItMedicinal = weedInput.nextLine();
        
        if (isItMedicinal.equalsIgnoreCase("y")) {
        	isMedicinal = true;
        } else {
        	isMedicinal = false;
        }
        
        System.out.println("Is the weed a poisonous kind of weed? (Please answer yes or no with y or n only");
        isItPoisnous = weedInput.nextLine();
        
        if (isItPoisnous.equalsIgnoreCase("y")) {
        	isPoisonous = true;
        } else {
        	isPoisonous = false;
        }
        
        Plant thePlant = new Weed(weedColor, weedID, weedName, isEdible, isMedicinal, isPoisonous);
        plantPack.add(thePlant);

	}

	private void removePlant(ArrayList<Plant> plantPack) {
		// Remove a plant that is specified by the user
		String plantName;
		Scanner plantInput = new Scanner(System.in);
		
		System.out.println("Please enter the name of the plant (regardless of the type (e.g. Plant, Flower, Fungus, Weed) that you would like to remove: ");
		plantName = plantInput.nextLine();
		
		for (Plant thePlant : plantPack) {
			if (thePlant.getName().equals(plantName)) {
				plantPack.remove(thePlant);
			}
		}
        

	}

	private void searchPlants(ArrayList<Plant> plantPack) {
		
		String plantName;
		Scanner plantInput = new Scanner(System.in);
		
		System.out.println("Please enter the name of the plant (regardless of the type (e.g. Plant, Flower, Fungus, Weed) that you would like to search: ");
		plantName = plantInput.nextLine();
		
		int index = -1;
		
		for (int i = 0; i < plantPack.size(); i++) { //done in O(n) time This is a linear search
			if (plantName.equalsIgnoreCase(plantPack.get(i).getName())) { 		
				index = i;
				break; 
			} 
		}
		if (index != -1) { 
			
			System.out.println("The search element : " + plantName + " was found");
		}
		
		else {

			System.out.println("The search element was not found in the arrayList.");
		}
		
		

	}

	private void displayPlants(ArrayList<Plant> plantPack) {
		
		for (Plant thePlant : plantPack) {
			System.out.println(thePlant.toString());
		}

	}
	
	private void filterPlants (ArrayList<Plant> plantPack) {
		// TODO Filter plant
		String plantName;
		Scanner plantInput = new Scanner(System.in);
		System.out.println("Enter the name of a plant to search by first character?");
		plantName = plantInput.nextLine();
		for (Plant thePlant : plantPack) {
			if(thePlant.getName().charAt(0) == plantName.charAt(0)) {
				System.out.println("Flowers based on the first character: "
						+ thePlant.toString());
			} 
		}
	}
	
	private void savePlantsToFile (ArrayList<Plant> plantPack) throws IOException {
		File plantFile = new File("plantFile.txt");
		FileOutputStream plantStream = new FileOutputStream(plantFile);
		PrintWriter plantOutStream = new PrintWriter(plantStream);
		for (Plant thePlant : plantPack) {
			plantOutStream.println(thePlant.toString());
		}
		plantOutStream.close();
	}
	
	private void readPlantsFromFile() throws FileNotFoundException {
		Scanner plantInput = new Scanner (new File ("plantInputData.txt"));
		try {
			while (plantInput.hasNext()) {
				
				Plant newPlant = new Plant(plantInput.next(), plantInput.next(), plantInput.next());
				System.out.println(newPlant.toString());
			}
		plantInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
