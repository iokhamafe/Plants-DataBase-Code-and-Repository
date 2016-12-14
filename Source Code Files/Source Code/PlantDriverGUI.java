import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlantDriverGUI extends JFrame {
        JRadioButton rdoBtnPlant, rdoBtnFlower, rdoBtnHerb, rdoBtnWeed, rdoBtnFungus;
        JCheckBox isPoisonous, isEdible, isMedicinal, isNicelyFlavored, isSeasonal, hasThorns, smellsNice;
        JButton btnAdd, btnRemove, btnFilter, btnClear, btnSort, btnDisplayPlants;
        JTextField txtPlantID, txtColor, txtName;
        JScrollPane scrollPane;
        JTextArea plantSummary;
        JMenuBar appMenu;
        JMenu fileMenu;
        JMenuItem open, save;
        
        ArrayList<Plant> plantList = new ArrayList();
        
	public PlantGUIDriverFinalAssignment() {
            try {
                this.setTitle("Iziren's Plant Interface");
                setLayout(new FlowLayout());
                JPanel plantPanel1 = new JPanel(); //Create a Pane to add components within them to better organize the UI
                JPanel plantPanel2 = new JPanel(); //Create another Panel to hold more plant components (checkboxes, etc)
                JPanel plantPanel3 = new JPanel(); //Create this panel to hold buttons.
                JPanel plantPanel4 = new JPanel(new BorderLayout()); //Create this Panel to hold TextArea plantSummary
                
                rdoBtnPlant = new JRadioButton("Plant");
                rdoBtnFlower = new JRadioButton("Flower");
                rdoBtnWeed = new JRadioButton("Weed");
                rdoBtnHerb = new JRadioButton("Herb");
                rdoBtnFungus = new JRadioButton("Fungus");                

                rdoBtnPlant.setSelected(true);

                //Create a group of Radio Buttons
                ButtonGroup plantSelection = new ButtonGroup();
                plantSelection.add(rdoBtnPlant);
                plantSelection.add(rdoBtnFlower);
                plantSelection.add(rdoBtnHerb);
                plantSelection.add(rdoBtnWeed);
                plantSelection.add(rdoBtnFungus);
                JLabel plantSelectLabel = new JLabel("Please select from the following plants to add below: ");
                plantSelectLabel.setFont(new Font("Serif", 20, 20));
                
                //Add radio buttons to contentPane
                add(plantSelectLabel);
                add(rdoBtnPlant);
                add(rdoBtnFlower);
                add(rdoBtnWeed);
                add(rdoBtnHerb);
                add(rdoBtnFungus);
                
                rdoBtnPlant.addActionListener(new RadioHandler());
                rdoBtnFlower.addActionListener(new RadioHandler());
                rdoBtnHerb.addActionListener(new RadioHandler());
                rdoBtnWeed.addActionListener(new RadioHandler());
                rdoBtnFungus.addActionListener(new RadioHandler());
                JLabel clrLabel = new JLabel("Enter Color:");
                
                txtColor = new JTextField("",15);
                
                JLabel plantIdentity = new JLabel("Enter Name:");
                
                txtName = new JTextField("",15);
                JLabel idLabel = new JLabel("Enter ID:");
                
                txtPlantID = new JTextField("", 15);
                
                plantPanel1.add(clrLabel);
                plantPanel1.add(txtColor);
                plantPanel1.add(plantIdentity);
                plantPanel1.add(txtName);
                plantPanel1.add(idLabel);
                plantPanel1.add(txtPlantID);
                add(plantPanel1);
                
                //Create CheckBoxes for Boolean value representations (0 and 1 / True or False)
                JLabel traits = new JLabel("Traits:");
                isPoisonous = new JCheckBox("Poisonous");
                isEdible = new JCheckBox("Edible");
                isMedicinal = new JCheckBox("Medicinal");
                isNicelyFlavored = new JCheckBox("Nice Flavor");
                isSeasonal = new JCheckBox("Seasonal");
                hasThorns = new JCheckBox("Thorny");
                smellsNice = new JCheckBox("Smells Nice");
                isPoisonous.setEnabled(false);
                isEdible.setEnabled(false);
                isMedicinal.setEnabled(false);
                isNicelyFlavored.setEnabled(false);
                isSeasonal.setEnabled(false);
                hasThorns.setEnabled(false);
                smellsNice.setEnabled(false);
                plantPanel2.add(traits);
                plantPanel2.add(isPoisonous);
                plantPanel2.add(isEdible);
                plantPanel2.add(isMedicinal);
                plantPanel2.add(isNicelyFlavored);
                plantPanel2.add(isSeasonal);
                plantPanel2.add(hasThorns);
                plantPanel2.add(smellsNice);
                
                add(plantPanel2);
                
               
                
                btnAdd = new JButton("Add");
                btnRemove = new JButton("Remove");
                btnSort = new JButton("Sort");
                btnDisplayPlants = new JButton("Display Plants");
                btnFilter = new JButton("Filter");
                btnClear = new JButton("Clear");
                btnAdd.addActionListener(new ButtonHandlerAdd());
                btnRemove.addActionListener(new ButtonHandlerRemove());
                btnDisplayPlants.addActionListener(new ButtonHandlerDisplay());
                btnClear.addActionListener(new ButtonHandlerClear());
                btnSort.addActionListener(new ButtonHandlerSort());
                btnFilter.addActionListener(new ButtonHandlerFilter());
                plantPanel3.add(btnAdd);
                plantPanel3.add(btnRemove);
                plantPanel3.add(btnSort);
                plantPanel3.add(btnDisplayPlants);
                plantPanel3.add(btnFilter);
                plantPanel3.add(btnClear);
                
                plantSummary = new JTextArea(10,20);
                plantSummary.setBackground(Color.WHITE);
                plantSummary.setFont(new Font("Verdana",Font.PLAIN, 14));
                
                plantSummary.setEditable(false);
                plantSummary.setVisible(true);
                
               
                scrollPane = new JScrollPane(plantSummary);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                plantPanel4.add(scrollPane, BorderLayout.SOUTH);
                appMenu = new JMenuBar();
                fileMenu = new JMenu("File");
                open = new JMenuItem("Open");
                save = new JMenuItem("Save");
                fileMenu.add(open);
                fileMenu.add(save);
                appMenu.add(fileMenu);
                setJMenuBar(appMenu);
                save.addActionListener(new FileMenuSaveFilter());
                open.addActionListener(new FileMenuOpenFilter());
                add(plantPanel3);
                add(plantPanel4);
                setSize(900, 600);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
                 
            } catch(Exception e) {
                System.out.println(e);
            }
            
        }
        
        public static void main(String[] args) {
            new PlantGUIDriverFinalAssignment();
        }
        
        private void addPlant() {
		//Add a plant that is specified by the user	

            String plantName = txtName.getText();            
            String plantColor = txtColor.getText();            
            String plantID = txtPlantID.getText();
            Plant thePlant = new Plant(plantColor, plantID, plantName);
            plantList.add(thePlant);
            
	}
        
        private void addFlower() {
		//Add a plant that is specified by the user
		String flowerName;
		String flowerColor;
		String flowerID;
		boolean scentType;
		String theScent;
                
		boolean isThorny;                
                flowerName = txtName.getText();
                flowerColor = txtColor.getText();
                flowerID = txtPlantID.getText();
                isThorny = hasThorns.isSelected();               
                scentType = smellsNice.isSelected();
                if (smellsNice.isSelected()) {
                    theScent = smellsNice.getText();
                }  else {
                    theScent = "No Scent";
                }
                Flower theFlower = new Flower(flowerColor, flowerID, flowerName, theScent, isThorny);
                plantList.add(theFlower);
                

	}
	
        private void addFungus() {
		//Add a plant that is specified by the user
		String fungusName;
		String fungusColor;
		String fungusID;
		
		boolean isItPoisonous;              
                
                fungusName = txtName.getText();                
                fungusColor = txtColor.getText();             
                fungusID = txtPlantID.getText();
                isItPoisonous = isPoisonous.isSelected();
                

                Fungus newFungus = new Fungus(fungusColor, fungusID, fungusName, isItPoisonous);
                plantList.add(newFungus);
                

        }
        
        private void addWeed() {
		//Add a plant that is specified by the user
		String weedName;
		String weedColor;
		String weedID;
		
		boolean isItEdible;
		
		boolean isItMedicinal;
		
		boolean isItPoisonous;	
      
                weedName = txtName.getText();
                weedColor = txtColor.getText();
                weedID = txtPlantID.getText();

                isItEdible = isEdible.isSelected();               
                isItMedicinal = isMedicinal.isSelected();
                isItPoisonous = isPoisonous.isSelected();
                Weed theWeed = new Weed(weedColor, weedID, weedName, isItEdible, isItMedicinal, isItPoisonous);
                plantList.add(theWeed);
                

	}
        
        private void addHerb() {
                //Add Herb Based off of these properties
                String herbName, herbColor, herbID, isGreatFlavor;
                boolean  isItMedicinal, isItSeasonal;
                
                herbName = txtName.getText();
                herbColor = txtColor.getText();
                herbID = txtPlantID.getText();
                
                if (isNicelyFlavored.isSelected()) {
                    isGreatFlavor = "Excellent and exquisite";
                } else {
                    isGreatFlavor = "Flavor isn't nice";
                }
                
                isItMedicinal = isMedicinal.isSelected();
                isItSeasonal = isSeasonal.isSelected();
                Herb theHerb = new Herb(herbColor, herbID, herbName, isGreatFlavor, isItMedicinal, isItSeasonal);
                plantList.add(theHerb);
                
                
        }
        
        private void sortPlants() {
	        //Instructions does not specify to use any sort Algorithm, so I will use default ArrayList sort
                // Sorting
            plantSummary.setText("");
            Collections.sort(plantList, new Comparator<Plant>() {
        
            @Override
            public int compare(Plant plant2, Plant plant1)
            {

                return  plant2.getName().compareTo(plant1.getName());
                
            }
            });
	    for (Plant thePlant : plantList) {
                plantSummary.append(thePlant.toString() + "\n");
            }
		    	
		    	
	}
        
        private void filterPlants() {
                plantSummary.setText("");
                String plantName = JOptionPane.showInputDialog(null, "Please enter the first character or part of a String of Plant to search for them");
			
		for (Plant thePlant : plantList) {
			if(thePlant.getName().charAt(0) == plantName.charAt(0)) {
                                plantSummary.append(thePlant.toString() + "\n");
				JOptionPane.showMessageDialog(null, "Please see the text Box for plants that begin with the first character of the sequence!");
                                
			} 
		}
        }
        
        private void savePlantsToFile () throws IOException {
		File plantFile = new File("plantFile.txt");
		FileOutputStream plantStream = new FileOutputStream(plantFile);
		PrintWriter plantOutStream = new PrintWriter(plantStream);
		for (Plant thePlant : plantList) {
			plantOutStream.println(thePlant.toString());
		}
		plantOutStream.close();
	}
        
        private void readPlantsFromFile() throws FileNotFoundException {
		Scanner plantInput = new Scanner (new File ("plantInputData.txt"));
		try {
			while (plantInput.hasNext()) {
				
				Plant newPlant = new Plant(plantInput.next(), plantInput.next(), plantInput.next());
				plantSummary.append(newPlant.toString() + "\n");
			}
		plantInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

    class RadioHandler implements ActionListener {



        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Plant")) {

                        isPoisonous.setEnabled(false);
                        isEdible.setEnabled(false);
                        isMedicinal.setEnabled(false);
                        isNicelyFlavored.setEnabled(false);
                        isSeasonal.setEnabled(false);
                        hasThorns.setEnabled(false);
                        smellsNice.setEnabled(false);

            } else if (e.getActionCommand().equals("Fungus")) {
                        isPoisonous.setEnabled(true);
                        isEdible.setEnabled(false);
                        isMedicinal.setEnabled(false);
                        isNicelyFlavored.setEnabled(false);
                        isSeasonal.setEnabled(false);
                        hasThorns.setEnabled(false);
                        smellsNice.setEnabled(false);
            } else if (e.getActionCommand().equals("Weed")) {
                        isPoisonous.setEnabled(true);
                        isEdible.setEnabled(true);
                        isMedicinal.setEnabled(true);
                        isNicelyFlavored.setEnabled(false);
                        isSeasonal.setEnabled(false);
                        hasThorns.setEnabled(false);
                        smellsNice.setEnabled(false);
            } else if (e.getActionCommand().equals("Flower")) {
                        hasThorns.setEnabled(true);
                        smellsNice.setEnabled(true);
                        isPoisonous.setEnabled(false);
                        isMedicinal.setEnabled(false);
                        isSeasonal.setEnabled(false);
                        isNicelyFlavored.setEnabled(false);
                        isEdible.setEnabled(false);
            } else if (e.getActionCommand().equals("Herb")) {
                        isPoisonous.setEnabled(false);
                        isEdible.setEnabled(false);
                        isMedicinal.setEnabled(true);
                        isNicelyFlavored.setEnabled(true);
                        isSeasonal.setEnabled(true);
                        hasThorns.setEnabled(false);
                        smellsNice.setEnabled(false);
            }
        }

    }
    
    class ButtonHandlerAdd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Add Button Clicked!");
            if (e.getActionCommand().equals("Add") && rdoBtnPlant.isSelected()) {                
                addPlant();
                
            } else if (e.getActionCommand().equals("Add") && rdoBtnFlower.isSelected()) {
                addFlower();
            } else if (e.getActionCommand().equals("Add") && rdoBtnFungus.isSelected()) {
                addFungus();
            } else if (e.getActionCommand().equals("Add") && rdoBtnWeed.isSelected()) {
                addWeed();
            } else if (e.getActionCommand().equals("Add") && rdoBtnHerb.isSelected()) {
                addHerb();
            }
           
        }
    }
    
    class ButtonHandlerRemove implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Remove Button Clicked!");
            if (e.getActionCommand().equals("Remove")) {
                String plantToRemove = JOptionPane.showInputDialog(null, "Please enter the name of the Plant (regardless of type) to remove:");
                for (Plant thePlant : plantList) {
                    if (thePlant.getName().equals(plantToRemove)) {
                        plantList.remove(thePlant);
                        JOptionPane.showMessageDialog (null, "Plant " + thePlant.getName() + " has been removed!");
                    } 
                }
               
            }           
                        
        }
    }
    
    class ButtonHandlerDisplay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            plantSummary.setText("");
            for (Plant thePlant : plantList) {
                plantSummary.append(thePlant.toString() + "\n");
            }
        }
    }
    
    class ButtonHandlerClear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            plantSummary.setText("");
        }
    }
    
    class ButtonHandlerSort implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sortPlants();
        }
    }
    
    class ButtonHandlerFilter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filterPlants();
        }
    }
    
    class FileMenuSaveFilter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                savePlantsToFile();
            } catch (IOException ex) {
                Logger.getLogger(PlantGUIDriverFinalAssignment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class FileMenuOpenFilter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                readPlantsFromFile();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PlantGUIDriverFinalAssignment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
}
