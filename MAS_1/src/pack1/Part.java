package pack1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Part implements Serializable {

	private static List<Part> partsList = new ArrayList<>(); // Ekstensja
	private String serialNumber;
	private String partName;
	private SpaceFactory factory = null; // Factory where part was produced
	private static long serialVersionUID = 1111111111;
	private Color color;
	private LocalDate dateAddedToDataBase;
	private Double packageWeight = null; // In kilograms. If null then no package needed. If 0, then package needed but
											// this particular part does not have one (ex. damaged).
	private double partWeight;

	public Part(String serialNumber, String partName, double weight, Color color) {
		this.serialNumber = serialNumber;
		this.partName = partName;
		this.partWeight = weight;
		factory = null;
		this.color = color;
		this.dateAddedToDataBase = LocalDate.now();
		addToPartsList(this);
	}

	////////////////// Ekstencja
	public static void addToPartsList(Part part) {
		partsList.add(part);
	}

	public void removeFromPartsList(Part part) {
		partsList.remove(part);
	}

	public static void showPartsList() {
		System.out.println("Parts list: ");
		for (Part part : partsList) {
			System.out.println(part);
		}
	}

	////////////////// Opcjonalny
	public void linkSpaceFactory(SpaceFactory factory1) {
		this.factory = factory1;
	}

	////////////////// Gettery i Settery
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serial) {
		this.serialNumber = serial;
	}

	public Double getPackageWeight() {
		return packageWeight;
	}

	public void setPackageWeight(Double kg) {
		this.packageWeight = kg;
	}

	public double getTotalWeight() {
		if (packageWeight != null) {
			return partWeight + packageWeight;
		} else
			return partWeight;
	}

	////////////////// Przes³oniêcie
	public String toString() {
		if (factory != null) {
			return "Part no." + serialNumber + ", " + partName + ", produced in factory: " + factory.getName();
		} else
			return "Part no." + serialNumber + ", " + partName
					+ ", no information about factory where part was produced.";
	}

	////////////////// Trwa³oœæ ekstencji
	public static void writeExtent(ObjectOutputStream out) throws IOException, FileNotFoundException {
		out.writeObject(partsList);
		out.close();

	}

	public static void readExtent(ObjectInputStream in)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		partsList = (ArrayList<Part>) in.readObject();
		in.close();
	}

}
