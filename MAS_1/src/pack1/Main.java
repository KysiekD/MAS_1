package pack1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ekstensja - lista 'partsList' w klasie Part. metoda 'addToPartsList'
		 * wywo³ywana jest w konstruktorze. --> + + + + + +
		 * 
		 * • Ekst. - trwa³oœæ - metody 'writeExtent' i 'readExtent' w klasie parts. -
		 * powinno to byæ zaimplementowane w inny sposób. Tj. przekazywaæ Stream a nie
		 * patha. --> POPRAWIONE.
		 * 
		 * • Atr. z³o¿ony - atr. 'SpaceFactory factory' w klasie Part. - Nie powinien
		 * byæ to Part, bo powinniœmy to zrobiæ przez asocjacjê, tylko atr. z³o¿ony z
		 * typów prostych. --> POPRAWKA: atr. 'Color color' w klasie 'Part'
		 * ZAIMPLEMENTOWANE. --> ew. atr. 'LocalDate dateAddedToDataBase' w klasie
		 * 'Part'. ZAIMPLEMENTOWANE.
		 * 
		 * • Atr. opcjonalny - atr. 'SpaceFactory factory' w klasie Part. - nie mozna
		 * ³¹czyæ przyk³adów, --> POPRAWKA: atr. opakowany 'Double packageWeight' w
		 * klasie 'Part' (czesc moze nie miec opakowania, np. jest trzymany luzem).
		 * Tak¿e zaimplementowanie sprawdzanie czy nie ma wartoœci null w
		 * 'getTotalWeight()'. ZAIMPLEMENTOWANE. --> ew. 'SpaceFactory factory' w klasie
		 * 'Part' (mozemy nie znac pierwotnej fabryki wytworzenia, np. œrubki). Jest te¿
		 * zaimplementowane sprawdzanie czy nie ma wartoœci null czy jej
		 * wyliczaniu/wypisywaniu(toString() ). ZAIMPELEMENTOWANE.
		 * 
		 * • Atr. powt.- atr. 'replacedPartsList' w klasie SpaceMachine. - nie powinno
		 * tam byæ klasy tylko jakiœ inny typ, najlepiej prosty. Te¿ cizko dostrzec
		 * biznesowego sensu tego pola. --> POPRAWKA: atr. 'List<String> manualLaguages'
		 * w klasie 'SpaceMachine'. Czyli lista zawiera informacje o jêzykach na jakie
		 * zosta³a przet³umaczona instrukcja do pojazdu kosmicznego. ZAIMPLEMENTOWANE.
		 * 
		 * • Atr. klasowy - 'productionYearOfNewestMachine' w klasie SpaceMachine. --> +
		 * + + + + +
		 * 
		 * • Atr. pochodny - metody get.. i set.. w klasie 'Part'. - powinien byæ to
		 * atrybut wyliczalny, który powsta³ z innych atrybutów. --> POPRAWKA:
		 * zrealizowane za pomoc¹ metody 'getTotalWeight' w klasie 'Part' (waga
		 * opakowania + waga czêœci). ZAIMPLEMENTOWANE.
		 * 
		 * • Met. klasowa - metoda 'showPartsList' w klasie 'Part'. - ciê¿ko dostrzec
		 * biznesowy sens u¿ycia. i nie mo¿na ³¹czyæ przyk³adów. --> POPRAWA: metoda
		 * 'changeInspectionPeriod' w klasie SpaceMachine. ZAIMPLEMENTOWANE. --> ew.
		 * metoda 'showMachinesList' w klasie SpaceMachine. ZAIMPLEMENTOWANE.
		 * 
		 * • Przes³oniêcie, przeci¹¿enie - metoda 'toString' w klasie 'Part', oraz
		 * metoda 'validateInfo' w klasie SpaceMachine. --> + + + + + +
		 */

		// /*
		SpaceFactory Factory1 = new SpaceFactory("Moon Factory");

		Color colorWhite = new Color("White", 10);
		Color colorSilver = new Color("Silver", 10);

		Part Part1 = new Part("1334401121", "Steel Ribbon", 1.3330, colorSilver);
		Part1.linkSpaceFactory(Factory1);
		Part1.getSerialNumber();
		Part1.setSerialNumber("0000000001");
		Part1.setPackageWeight(23.112);
		System.out.println(Part1 + " - total weight: " + Double.toString(Part1.getTotalWeight()));

		Part Part2 = new Part("1334401122", "Screw X21S", 0.1122, colorSilver);
		Part2.linkSpaceFactory(Factory1);
		System.out.println(Part2);

		Part Part3 = new Part("1334401123", "Cockpit Desktop AA223", 23.2122, colorWhite);
		Part3.setPackageWeight(1.233);
		Part3.getTotalWeight();

		Part Part4 = new Part("1334401124", "Back Door", 60.3460, colorWhite);
		Part4.linkSpaceFactory(Factory1);
		Part4.getTotalWeight();

		Part.showPartsList();

		SpaceMachine Machine1 = new SpaceMachine("Strider");
		Machine1.addToManualLanguageList("German");
		Machine1.addToManualLanguageList("English");

		SpaceMachine.setStaticProductionYearOfNewestMachine(2018);

		Machine1.validateInfo("Strider");
		SpaceMachine.showMachinesList();
		SpaceMachine.changeInspectionPeriod(8);
		// */

		// WRITE EXTENSION:
		/// *
		String path = "C:\\Users\\Wygrany\\Desktop\\Extent.txt";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
			Part.writeExtent(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// */

		// ===========================

		// READ EXTENSION:
		//
		/*
		 * try { String path = "C:\\Users\\Wygrany\\Desktop\\Extent.txt";
		 * ObjectInputStream inStream = new ObjectInputStream(new
		 * FileInputStream(path)); Part.readExtent(inStream); } catch
		 * (ClassNotFoundException | IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } //
		 */

		Part.showPartsList();

	}

}
