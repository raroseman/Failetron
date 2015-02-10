package assignment2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PartsInventoryModel {
	private List<Part> partsInventory;
	private Comparator<Part> sortingMode = Part.PartNameDescending; // default sort
	
	public PartsInventoryModel() {
		partsInventory = new ArrayList<Part>();
	}
	
	public void addPart(Part p) throws Exception {
		try {
<<<<<<< HEAD
			addPart(p.getID(), p.getQuantity(), p.getQuantityUnitType(), p.getPartName(), p.getPartNumber(), p.getVendor(), p.getLocation());
=======
			addPart(p.getID(), p.getQuantity(), p.getQuantityUnitType(), p.getPartName(), p.getPartNumber(), p.getExternalNumber(), p.getVendor());
>>>>>>> Change request 3 complete
		}
		catch (IOException e) {
			throw new IOException(e.getMessage());
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
<<<<<<< HEAD
	public void addPart(Integer id, Integer quantity, String unitOfQuantity, String partName, String partNumber, String location) throws Exception {
		try {
<<<<<<< HEAD
			addPart(id, quantity, unitOfQuantity, partName, partNumber, "");

=======
			addPart(id, quantity, unitOfQuantity, partName, partNumber, location);
>>>>>>> Updated the Part class to include a set of locations (String[]) and a variable for the part's location. Also included getter and setter, with appropriate exceptions thrown for unknown/unrecognized locations (meets the 'required' criteria). Finally, updated JUnit tests to reflect new constructors for the Part, and created new JUnit tests for the location requirements. Also had to update the PartsInventoryModel to reflect the new Part constructors.
=======
	public void addPart(Integer id, Integer quantity, String unitOfQuantity, String partName, String partNumber, String externalPartNumber) throws Exception {
		try {
			addPart(id, quantity, unitOfQuantity, partName, partNumber, externalPartNumber, "");
>>>>>>> Change request 3 complete
		}
		catch (IOException e) {
			throw new IOException(e.getMessage());
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
<<<<<<< HEAD
<<<<<<< HEAD

	public void addPart(Integer id, Integer quantity, String unitOfQuantity, String partName, String partNumber, String vendor) throws Exception, IOException {
=======
	public void addPart(Integer id, Integer quantity, String unitOfQuantity, String partName, String partNumber, String vendor, String location) throws Exception, IOException {
>>>>>>> Updated the Part class to include a set of locations (String[]) and a variable for the part's location. Also included getter and setter, with appropriate exceptions thrown for unknown/unrecognized locations (meets the 'required' criteria). Finally, updated JUnit tests to reflect new constructors for the Part, and created new JUnit tests for the location requirements. Also had to update the PartsInventoryModel to reflect the new Part constructors.
=======
	public void addPart(Integer id, Integer quantity, String unitOfQuantity, String partName, String partNumber, String externalPartNumber, String vendor) throws Exception, IOException {
>>>>>>> Change request 3 complete
		if (quantity <= 0) {
			throw new IOException("A new item requires quantity greater than zero.");
		}
		try {
<<<<<<< HEAD
<<<<<<< HEAD
			Part p = new Part(id, quantity, unitOfQuantity, partName, partNumber, vendor);

=======
			Part p = new Part(id, quantity, unitOfQuantity, partName, partNumber, vendor, location);
>>>>>>> Updated the Part class to include a set of locations (String[]) and a variable for the part's location. Also included getter and setter, with appropriate exceptions thrown for unknown/unrecognized locations (meets the 'required' criteria). Finally, updated JUnit tests to reflect new constructors for the Part, and created new JUnit tests for the location requirements. Also had to update the PartsInventoryModel to reflect the new Part constructors.
=======
			Part p = new Part(id, quantity, unitOfQuantity, partName, partNumber, externalPartNumber, vendor);
>>>>>>> Change request 3 complete
			if (findPartName(p.getPartName()) != null) {
				throw new Exception("Part name \"" + p.getPartName() + "\" is already listed in inventory.");
			}
			partsInventory.add(p);
		}
		catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}
	
	public void deletePart(Part p) {
		partsInventory.remove(p); // if it exists, first instance (unique, only one entry) is removed. otherwise does nothing
	}
	
	public void deletePart(String partName) {
		Part p = findPartName(partName);
		if (p != null) {
			partsInventory.remove(p); // if it exists, first instance (unique, only one entry) is removed. otherwise does nothing
		}
	}
	
	public void editPart(Part partOld, Part partNew) throws Exception {
		int index = partsInventory.indexOf(partOld);
		//if (index == -1) {
		//	throw new Exception("Error: the old part, " + partOld.getPartName() + " cannot be edited as it is not listed in inventory.");
		//}
		
		// If the item being edited did not originally have the new part name AND the new part name is already taken, throw an error
		// Otherwise, the name remains the same, and it should be OK to keep
		if (!partOld.getPartName().equals(partNew.getPartName()) && findPartName(partNew.getPartName()) != null) {
			//throw new Exception("Part name \"" + partNew.getPartName() + "\" is already listed in inventory.");
			throw new Exception("Error: part name already exists in the inventory.");
		} else {
			partsInventory.set(index, partNew);
		}
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public void editPart(Part partOld, int newID, int newQuantity, String newQuantityUnitType, String newName, String newPartNumber, String newVendor) throws Exception {

=======
	public void editPart(Part partOld, int newID, int newQuantity, String newQuantityUnitType, String newName, String newPartNumber, String newVendor, String newLocation) throws Exception {
>>>>>>> Updated PartsInventoryView, PartView, PartController, and the JUnit test for the PartsInventoryView. Specifically, added MVC functionality for the part location data, including column header sorting, editability in the PartView, modifying the PartView to show location, and including the location information in the controller.
=======
	public void editPart(Part partOld, int newID, int newQuantity, String newQuantityUnitType, String newName, String newPartNumber, String newExternalPartNumber, String newVendor) throws Exception {
>>>>>>> Change request 3 complete
		int index = partsInventory.indexOf(partOld);
	//	if (index == -1) {
	//		throw new Exception("Error: the old part, " + partOld.getPartName() + " cannot be edited as it is not listed in inventory.");
	//	}
		
		if (!partOld.getPartName().equals(newName) && findPartName(newName) != null) {
			//throw new Exception("Part name \"" + newName + "\" is already listed in inventory.");
			throw new Exception("Error: part name already exists in the inventory.");
		} else {
<<<<<<< HEAD
			Part newPart = new Part(newID, newQuantity, newQuantityUnitType, newName, newPartNumber, newVendor, newLocation);
=======
			Part newPart = new Part(newID, newQuantity, newQuantityUnitType, newName, newPartNumber, newExternalPartNumber, newVendor);
>>>>>>> Change request 3 complete
			partsInventory.set(index, newPart);
		}
	}
	
	public Part findPartName(String partName) {
		if (partName.length() > Part.getMaxPartNameLength()) {
			partName = partName.substring(0, Part.getMaxPartNameLength()); // maybe just throw length exceeded exception...
		}
		for (Part part : partsInventory) { // this is O(n)
			if (part.getPartName().equals(partName)) {
				return part;
			}
		}
		return null;
	}
	
	public Part findPartNumber(String partNumber) {
		if (partNumber.length() > Part.getMaxPartNumberLength()) {
			partNumber = partNumber.substring(0, Part.getMaxPartNumberLength());
		}
		for (Part part : partsInventory) { // this is O(n)
			if (part.getPartNumber().equals(partNumber)) {
				return part;
			}
		}
		return null;
	}
	
	public void printInventory() { // for debugging, console, or file output
		String horizontalSeparator = "";
		int recordNum = 1;
		for (int i = 0; i < 80; i++) {
			horizontalSeparator += '-';
		}
		System.out.printf("%8s   %17s   %17s   %8s   %17s   %17s\n",
				"Record #", "Part #", "Part Name", "Quantity", "Quantity Unit Type", "Vendor");
		System.out.println(horizontalSeparator);
		for (Part part : partsInventory) {
			System.out.printf("%8s | %17s | %17s | %8s | %17s | %17s\n",
					recordNum++, part.getPartNumber(), part.getPartName(), part.getQuantity(), part.getQuantityUnitType(), part.getExternalNumber());
			System.out.println(horizontalSeparator);
		}
	}
	
	public int getSize() {
		return partsInventory.size();
	}
	
	public List<Part> getInventory() { // for GUI output
		return partsInventory;
	}
	
	public String[] getValidQuantityUnitTypes() {
		return Part.getValidQuantityUnitTypes();
	}
	
	public String[] getValidLocationTypes() {
		return Part.getValidLocationTypes();
	}
	
	public void sortByQuantity() {
		if (sortingMode == Part.QuantityDescending) {
			sortingMode = Part.QuantityAscending;
		}
		else {
			sortingMode = Part.QuantityDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
	public void sortByQuantityUnitType() {
		if (sortingMode == Part.QuantityUnitTypeDescending) {
			sortingMode = Part.QuantityUnitTypeAscending;
		}
		else {
			sortingMode = Part.QuantityUnitTypeDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
	public void sortByPartName() {
		if (sortingMode == Part.PartNameDescending) {
			sortingMode = Part.PartNameAscending;
		}
		else {
			sortingMode = Part.PartNameDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
	public void sortByPartNumber() {
		if (sortingMode == Part.PartNumberDescending) {
			sortingMode = Part.PartNumberAscending;
		}
		else {
			sortingMode = Part.PartNumberDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
	public void sortByVendor() {
		if (sortingMode == Part.VendorDescending) {
			sortingMode = Part.VendorAscending;
		}
		else {
			sortingMode = Part.VendorDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
	public void sortByLocation() {
		if (sortingMode == Part.LocationDescending) {
			sortingMode = Part.LocationAscending;
		}
		else {
			sortingMode = Part.LocationDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
	public void sortByID() {
		if (sortingMode == Part.IDDescending) {
			sortingMode = Part.IDAscending;
		}
		else {
			sortingMode = Part.IDDescending;
		}
		partsInventory.sort(sortingMode);
	}
	
}
