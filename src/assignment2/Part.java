package assignment2;

import java.io.IOException;
import java.util.Comparator;

public class Part implements Comparable<Part> {
	private Integer id = 0;
	private Integer quantity = 0;
	private String partName = "";
	private String partNumber = "";
	private String externalPartNumber = "";
	private String vendor = "";
	private String quantityUnitType = "Unknown";
	private String location = "";
	private static String[] locationTypes = new String[] { "Unknown", "Facility 1 Warehouse 1", "Facility 1 Warehouse 2", "Facility 2" };
	private static String[] unitTypes = new String[] { "Unknown", "Linear Feet", "Pieces" };
	private static int maxPartNameLength = 255;
	private static int maxPartNumberLength = 20;
	private static int maxVendorLength = 255;
	private static int maxExternalNumberLength = 50;
	

	public Part(Integer id, Integer quantity, String quantityUnitType, String partName, String partNum, String externalPartNumber, String location) throws IOException {
		try {
			setID(id);
			setQuantity(quantity);
			setQuantityUnitType(quantityUnitType);
			setPartName(partName);
			setPartNumber(partNum);
			setExternalPartNumber(externalPartNumber);
			setLocation(location);
		}
		catch (IOException e) {
			//throw new IOException("Exception thrown during Part creation: \n\t" + e);
			throw new IOException(e.getMessage());
		}
	}
	

	public Part(Integer id, Integer quantity, String quantityUnitType, String partName, String partNum, String externalPartNumber, String location, String vendor) throws IOException {
		this(id, quantity, quantityUnitType, partName, partNum, externalPartNumber, location);
		setVendor(vendor);
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public String getQuantityUnitType() {
		return this.quantityUnitType;
	}
	
	public static String[] getValidQuantityUnitTypes() {
		return unitTypes;
	}
	
	public static String[] getValidLocationTypes() {
		return locationTypes;
	}
	
	public String getPartName() {
		return this.partName;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public String getPartNumber() {
		return this.partNumber;
	}
	
	public String getExternalNumber() {
		return this.externalPartNumber;
	}
	
	public String getVendor() {
		return this.vendor;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	@Override
	public String toString() {
		//int width; // 
		//String format = "%" + width + "s" + "%" + width + "s" + "%" + width + "s" + "%" + width + "s";
		//return String.format(format, getPartName(), getPartNumber(), getVendor(), getQuantity());
		return getPartName() + " | " + getPartNumber() + " | " + getVendor() + " | " + getQuantity(); // looks bad, would prefer separated adjustable columns
	}
	
	public static int getMaxPartNameLength() {
		return maxPartNameLength;
	}
	
	public static int getMaxPartNumberLength() {
		return maxPartNumberLength;
	}
	
	public static int getMaxVendorLength() {
		return maxVendorLength;
	}
	
	private void setID(Integer id) throws IOException {
		if (id < 1) {
			throw new IOException("Error: cannot assign negative value to quantity.");
		}
		else {
			this.id = id;
		}
	}
	
	private void setQuantity(Integer quantity) throws IOException {
		if (quantity < 0) {
			throw new IOException("Error: cannot assign negative value to quantity.");
		}
		else {
			this.quantity = quantity;
		}
	}
	
	private void setQuantityUnitType(String quantityUnitType) throws IOException {
		for (String unit : unitTypes) {
			if (unit.equals(quantityUnitType) && !unit.equals("Unknown")) {
				this.quantityUnitType = quantityUnitType.trim();
				return;
			}
			else if (unit.equals(quantityUnitType) && unit.equals("Unknown")) {
				throw new IOException("Error: unit type cannot be listed as \"unknown.\"");
			}
		}
		throw new IOException("Error: unit type unrecognized.");
	}
	
	private void setLocation(String location) throws IOException {
		for (String loc : locationTypes) {
			if (loc.equals(location) && !loc.equals("Unknown")) {
				this.location = location.trim();
				return;
			}
			else if (loc.equals(location) && loc.equals("Unknown")) {
				throw new IOException("Error: location cannot be listed as \"unknown.\"");
			}
		}
		throw new IOException("Error: location unrecognized.");
	}
	
	private void setPartName(String partName) throws IOException {
		if (partName.length() > maxPartNameLength) {
			throw new IOException("Error: part name is too long (" + maxPartNameLength + " characters max).");
		}
		else if (partName.trim().length() == 0) {
			throw new IOException("Error: part name is required.");
		}
		else {
			this.partName = partName.trim();
		}
	}
	
	private void setPartNumber(String partNumber) throws IOException {
		if (partNumber.length() > maxPartNumberLength) {
			throw new IOException("Error: part number is too long (" + maxPartNumberLength + " characters max).");
		}
		else if (partNumber.trim().length() == 0) {
			throw new IOException("Error: part number is required.");
		}
		else {
			this.partNumber = partNumber.trim();
		}
	}
	
	private void setExternalPartNumber(String externalPartNumber) throws IOException {
		if (externalPartNumber.length() > maxExternalNumberLength) {
			throw new IOException("Error: external part number is too long (" + maxExternalNumberLength + " characters max).");
		}
		else {
			this.externalPartNumber = externalPartNumber.trim();
		}
	}
	
	private void setVendor(String vendor) throws IOException {
		if (vendor.length() > maxVendorLength) {
			throw new IOException("Error: vendor name is too long (" + maxVendorLength + " characters max).");
		}
		else {
			this.vendor = vendor.trim();
		}
	}

	// used to sort by quantity in descending order
	public static Comparator<Part> QuantityDescending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			Integer quantity1 = part.getQuantity();
			Integer quantity2 = anotherPart.getQuantity();
			return quantity1.compareTo(quantity2);
		}
	};
	
	// used to sort by quantity in ascending order
	public static Comparator<Part> QuantityAscending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			Integer quantity1 = part.getQuantity();
			Integer quantity2 = anotherPart.getQuantity();
			return quantity2.compareTo(quantity1);
		}
	};
	
	// used to sort by unit type in descending order
		public static Comparator<Part> QuantityUnitTypeDescending = new Comparator<Part>() {
			public int compare(Part part, Part anotherPart) {
				String unitType1 = part.getQuantityUnitType();
				String unitType2 = anotherPart.getQuantityUnitType();
				return unitType1.compareTo(unitType2);
			}
		};
		
		// used to sort by unit type in ascending order
		public static Comparator<Part> QuantityUnitTypeAscending = new Comparator<Part>() {
			public int compare(Part part, Part anotherPart) {
				String unitType1 = part.getQuantityUnitType();
				String unitType2 = anotherPart.getQuantityUnitType();
				return unitType2.compareTo(unitType1);
			}
		};
	
	// used to sort by part name in descending order
	public static Comparator<Part> PartNameDescending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String partName1 = part.getPartName().toUpperCase();
			String partName2 = anotherPart.getPartName().toUpperCase();
			return partName1.compareTo(partName2);
		}
	};
	
	// used to sort by part name in ascending order
	public static Comparator<Part> PartNameAscending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String partName1 = part.getPartName().toUpperCase();
			String partName2 = anotherPart.getPartName().toUpperCase();
			return partName2.compareTo(partName1);
		}
	};
	
	// used to sort by part number in descending order
	public static Comparator<Part> PartNumberDescending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String partNumber1 = part.getPartNumber().toUpperCase();
			String partNumber2 = anotherPart.getPartNumber().toUpperCase();
			return partNumber1.compareTo(partNumber2);
		}
	};
	
	// used to sort by part number in ascending order
	public static Comparator<Part> PartNumberAscending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String partNumber1 = part.getPartNumber().toUpperCase();
			String partNumber2 = anotherPart.getPartNumber().toUpperCase();
			return partNumber2.compareTo(partNumber1);
		}
	};
	
	// used to sort by vendor in descending order
	public static Comparator<Part> VendorDescending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String vendor1 = part.getVendor().toUpperCase();
			String vendor2 = anotherPart.getVendor().toUpperCase();
			return vendor1.compareTo(vendor2);
		}
	};
	
	// used to sort by vendor in ascending order
	public static Comparator<Part> VendorAscending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String vendor1 = part.getVendor().toUpperCase();
			String vendor2 = anotherPart.getVendor().toUpperCase();
			return vendor2.compareTo(vendor1);
		}
	};
	
	// used to sort by location in descending order
	public static Comparator<Part> LocationDescending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String vendor1 = part.getLocation().toUpperCase();
			String vendor2 = anotherPart.getLocation().toUpperCase();
			return vendor1.compareTo(vendor2);
		}
	};
	
	// used to sort by location in ascending order
	public static Comparator<Part> LocationAscending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			String vendor1 = part.getLocation().toUpperCase();
			String vendor2 = anotherPart.getLocation().toUpperCase();
			return vendor2.compareTo(vendor1);
		}
	};
	
	// used to sort by location in descending order
	public static Comparator<Part> IDDescending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			Integer vendor1 = part.getID();
			Integer vendor2 = anotherPart.getID();
			return vendor1.compareTo(vendor2);
		}
	};
	
	// used to sort by location in ascending order
	public static Comparator<Part> IDAscending = new Comparator<Part>() {
		public int compare(Part part, Part anotherPart) {
			Integer vendor1 = part.getID();
			Integer vendor2 = anotherPart.getID();
			return vendor2.compareTo(vendor1);
		}
	};
	
	@Override
	public int compareTo(Part o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}