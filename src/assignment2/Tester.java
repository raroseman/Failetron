package assignment2;

import java.io.IOException;

/*
 * 
 * CS 4743 assignment 2
 * Written by Josef Klein and Ryan Roseman
 * 
 */

public class Tester {
	private static PartsInventoryView partsInventoryView;
	private static PartsInventoryController partsInventoryController;
	private static PartsInventoryModel partsInventoryModel;
	
	public static void main(String args[]) {
		partsInventoryModel = new PartsInventoryModel();
	
		for (int i = 1; i < 58; i++) {
			try {
<<<<<<< HEAD
				Part p = new Part(i, i, "Pieces", "MyPartName" + i, "MyPartNumber" + i, "Vendor" + i);

=======
				Part p = new Part(i, i, "Pieces", "MyPartName" + i, "MyPartNumber" + i, "Vendor" + i, "Facility 2");
>>>>>>> Updated PartsInventoryView, PartView, PartController, and the JUnit test for the PartsInventoryView. Specifically, added MVC functionality for the part location data, including column header sorting, editability in the PartView, modifying the PartView to show location, and including the location information in the controller.
				partsInventoryModel.addPart(p);
			}
			catch (IOException e) {
				e.printStackTrace();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		partsInventoryView = new PartsInventoryView(partsInventoryModel);
		
		partsInventoryController = new PartsInventoryController(partsInventoryModel, partsInventoryView);
			
		partsInventoryView.register(partsInventoryController);
		
		
		
	}
}
