import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NenSimulation {
	public static ArrayList<NenUser> hunters = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int currentNumberOfHunters = 0;
		do {
			addHunters();

			System.out.println("\n=====================================");
			System.out.println("...Water Divination Test Ongoing!...");
			System.out.println("=====================================\n");
			hunters.get(currentNumberOfHunters).waterDivination();
			System.out.println("\n=====================================");
			System.out.println("...Water Divination Test Complete!...");
			System.out.println("=====================================");
			System.out.println("\n===" + hunters.get(currentNumberOfHunters).getUserName() + " Stats" + "===\n");
			hunters.get(currentNumberOfHunters).showStats();
			hunters.get(currentNumberOfHunters).assignSubTypes();
			System.out.println("=====================================");
			System.out.println();
			currentNumberOfHunters++;
		} while (tryAgain("TRY AGAIN? "));

		// Summary of results
		System.out.println("\n=====================================");
		System.out.println("...Summary!");
		System.out.println("=====================================\n");

		HashMap<String, Integer> nenTypeCount = new HashMap<>();

		for (NenUser hunter : hunters) {
			System.out.println("Hunter Name: " + hunter.getUserName());
			hunter.showStats();
			System.out.println();

    		NenType typeObj = hunter.getNenType();
    		if (typeObj != null) {
        		String typeName = typeObj.getName();
        		nenTypeCount.put(typeName, nenTypeCount.getOrDefault(typeName, 0) + 1);
    		}
		}
		
		System.out.println("=== Nen Type Distribution ===");
		for (String type : nenTypeCount.keySet()) {
    		System.out.println(type + ": " + nenTypeCount.get(type));
		}
		sc.close();
	}

	public static void addHunters() {
		System.out.print("\nNen User Name: ");
		String name = sc.nextLine().trim();
		NenUser newNenUser = new NenUser(name);
		hunters.add(newNenUser);
	}

	public static boolean tryAgain(String instructions) {
		String input;
		System.out.print(instructions);
		input = sc.nextLine();
		return input.matches("[yY]");
	}
}