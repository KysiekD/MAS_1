package pack1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SpaceMachine {
	private static int productionYearOfNewestMachine = 2011;
	private List<String> manualLaguages;
	private static List<SpaceMachine> machinesList = new ArrayList<>();
	private String name;
	private static int inspectionPerioidInMonths = 12; // After each period inspection and repairs (if necessary) of the
														// machine have to be made

	public SpaceMachine(String name) {
		this.name = name;
		manualLaguages = new ArrayList<>();
		addToMachinesList(this);
	}

	public void addToMachinesList(SpaceMachine machine) {
		machinesList.add(this);
	}

	public static void showMachinesList() {
		System.out.println("Machines list: ");
		for (SpaceMachine machine : machinesList) {
			System.out.println(machine.name);
		}
	}

	public static void changeInspectionPeriod(int period) {
		inspectionPerioidInMonths = period;
	}

	void addToManualLanguageList(String language) {
		manualLaguages.add(language);
	}

	public static void setStaticProductionYearOfNewestMachine(int year) {
		SpaceMachine.productionYearOfNewestMachine = year;
	}

	public boolean validateInfo(String name) {
		if (name.equals(this.name)) {
			return true;
		} else
			return false;
	}

}
