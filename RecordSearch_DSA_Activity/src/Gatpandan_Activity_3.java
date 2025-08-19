import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Gatpandan_Activity_3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Record.txt");
        String[][] dataStorage = new String[10][5];
        Scanner inputScanner = new Scanner(System.in);

        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                scanFile(fileScanner, dataStorage);
            }
        } else {
            System.out.println("File not found.");
            return;
        }

        System.out.println("Menu: \nA) Name \nB) Age \nC) City \nD) Job \nE) Income Level");
        System.out.print("Select the field you want to search (A/B/C/D/E): ");
        String categoryChoice = inputScanner.nextLine().toUpperCase().trim();

        switch (categoryChoice) {
            case "A":
            case "NAME":
                search(0, dataStorage, inputScanner, "Name");
                break;
            case "B":
            case "AGE":
                search(1, dataStorage, inputScanner, "Age");
                break;
            case "C":
            case "CITY":
                search(2, dataStorage, inputScanner, "City");
                break;
            case "D":
            case "JOB":
                search(3, dataStorage, inputScanner, "Job");
                break;
            case "E":
            case "INCOME LEVEL":
                search(4, dataStorage, inputScanner, "Income Level");
                break;
            default:
                System.out.println("Invalid selection. Enter A, B, C, D, or E, or the full category name.");
        }

    }

    private static void search(int category, String[][] dataStorage, Scanner inputScanner, String categoryName) {
        System.out.print("Enter the " + categoryName + " you want to search: ");
        String text = inputScanner.nextLine().trim();
        int recordCount = 0;

        for (int row = 0; row < dataStorage.length; row++) {
            if (dataStorage[row] != null && dataStorage[row].length > category && dataStorage[row][category] != null && dataStorage[row][category].equalsIgnoreCase(text)) {
                printData(dataStorage[row]);
                recordCount++;
            }
        }
        System.out.println("\nTotal Record: " + recordCount);
    }

    private static void printData(String[] data) {
        System.out.println("\nName: " + data[0]);
        System.out.println("Age: " + data[1]);
        System.out.println("City: " + data[2]);
        System.out.println("Job: " + data[3]);
        System.out.println("Income Level: " + data[4]);
    }

    private static void scanFile(Scanner fileScanner, String[][] dataStorage) {
        int row = 0;
        while (fileScanner.hasNext() && row < dataStorage.length) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                dataStorage[row] = line.split(",", 5);
                row++;
            }
        }
    }
}
