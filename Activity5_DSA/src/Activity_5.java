import java.io.File;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Activity_5 {
    // Create 3 LinkeList to store data of each field
    static LinkedList<String> nameList = new LinkedList<String>();
    static LinkedList<String> ageList = new LinkedList<String>();
    static LinkedList<String> genderList = new LinkedList<String>();

    // ANSI color codes for better UI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) throws Exception {
        File file = new File("records.txt");

        try (Scanner inputScanner = new Scanner(System.in)) {
            // Check if the file exist and scan that file
            if (file.exists()) {
                nameList.clear();
                ageList.clear();
                genderList.clear();
                try (Scanner fileScanner = new Scanner(file)) {
                    storeData(fileScanner, nameList, ageList, genderList);
                }
            }
            
            // Display welcome message
            displayWelcome();
            
            // Main program loop
            while (true) {
                displayMainMenu();
                int menuChoice = getMenuChoice(inputScanner);
                
                if (menuChoice == 0) {
                    displayGoodbye();
                    break;
                }
                
                processMenuChoice(menuChoice, inputScanner);
                
                // Pause before showing menu again
                System.out.println("\n" + CYAN + "Press Enter to continue..." + RESET);
                inputScanner.nextLine();
                clearScreen();
            }
        }
    }

    private static void displayWelcome() {
        clearScreen();
        System.out.println(BOLD + BLUE + "╔══════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + BLUE + "║                    RECORD MANAGEMENT SYSTEM                   ║" + RESET);
        System.out.println(BOLD + BLUE + "║                        Activity 5 - DSA                       ║" + RESET);
        System.out.println(BOLD + BLUE + "╚══════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        System.out.println(GREEN + "✓ System initialized successfully!" + RESET);
        System.out.println(GREEN + "✓ Records loaded from file: " + nameList.size() + " entries found" + RESET);
        System.out.println();
    }

    private static void displayMainMenu() {
        System.out.println(BOLD + PURPLE + "╔══════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + PURPLE + "║                         MAIN MENU                            ║" + RESET);
        System.out.println(BOLD + PURPLE + "╠══════════════════════════════════════════════════════════════╣" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[1]" + RESET + " Add Record to First                                    " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[2]" + RESET + " Add Record to Last                                     " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[3]" + RESET + " Remove First Record                                   " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[4]" + RESET + " Remove Last Record                                    " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[5]" + RESET + " Display All Records                                   " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[6]" + RESET + " Display Specific Record                               " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[7]" + RESET + " Edit Record                                           " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "║" + RESET + "  " + YELLOW + "[0]" + RESET + " Exit                                                  " + BOLD + PURPLE + "║" + RESET);
        System.out.println(BOLD + PURPLE + "╚══════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    private static int getMenuChoice(Scanner inputScanner) {
        while (true) {
            System.out.print(CYAN + "Enter your choice: " + RESET);
            
            if (!inputScanner.hasNextInt()) {
                System.out.println(RED + "❌ Invalid input. Please enter a number between 0 and 7." + RESET);
                inputScanner.nextLine();
                continue;
            }
            
            int choice = inputScanner.nextInt();
            inputScanner.nextLine();
            
            if (choice >= 0 && choice <= 7) {
                return choice;
            } else {
                System.out.println(RED + "❌ Invalid choice. Please enter a number between 0 and 7." + RESET);
            }
        }
    }

    private static void processMenuChoice(int choice, Scanner inputScanner) throws Exception {
        System.out.println();
        switch (choice) {
            case 1: 
                System.out.println(BOLD + GREEN + "=== ADD RECORD TO FIRST ===" + RESET);
                addRecord("first", inputScanner);
                break;
            case 2: 
                System.out.println(BOLD + GREEN + "=== ADD RECORD TO LAST ===" + RESET);
                addRecord("last", inputScanner);
                break;
            case 3: 
                System.out.println(BOLD + GREEN + "=== REMOVE FIRST RECORD ===" + RESET);
                removeRecord("first");
                break;
            case 4: 
                System.out.println(BOLD + GREEN + "=== REMOVE LAST RECORD ===" + RESET);
                removeRecord("last");
                break;
            case 5: 
                System.out.println(BOLD + GREEN + "=== DISPLAY ALL RECORDS ===" + RESET);
                displayAllRecord();
                break;
            case 6: 
                System.out.println(BOLD + GREEN + "=== DISPLAY SPECIFIC RECORD ===" + RESET);
                displaySpecificRecord(inputScanner);
                break;
            case 7: 
                System.out.println(BOLD + GREEN + "=== EDIT RECORD ===" + RESET);
                editRecord(inputScanner);
                break;
        }
    }

    private static void displayGoodbye() {
        System.out.println();
        System.out.println(BOLD + BLUE + "╔══════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + BLUE + "║                    THANK YOU FOR USING                        ║" + RESET);
        System.out.println(BOLD + BLUE + "║                  RECORD MANAGEMENT SYSTEM                     ║" + RESET);
        System.out.println(BOLD + BLUE + "╚══════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(GREEN + "✓ All changes have been saved to records.txt" + RESET);
        System.out.println(GREEN + "✓ Goodbye!" + RESET);
    }

    private static void clearScreen() {
        // Clear screen for better UI (works on most terminals)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method that get the user input and add it to the correct position
    private static void addRecord(String position, Scanner inputScanner) throws Exception {
        String[] fields = { "name", "age", "gender" };
        String[] records = new String[3];

        System.out.println(YELLOW + "Please enter the following information:" + RESET);
        System.out.println();

        // Get the user input based on the field type
        for (int j = 0; j < records.length; j++) {
            records[j] = getRecordInput(inputScanner, fields[j]);
        }

        // Add the user input in its correct position
        if (position.equals("first")) {
            nameList.addFirst(records[0]);
            ageList.addFirst(records[1]);
            genderList.addFirst(records[2]);
        } else {
            nameList.addLast(records[0]);
            ageList.addLast(records[1]);
            genderList.addLast(records[2]);
        }
        // Call the updateFile method that write the new record into the txt file
        updateFile();
        System.out.println(GREEN + "✓ Record added successfully to " + position + " position." + RESET);
    }

    // Method that remove a record based on chosen position
    private static void removeRecord(String position) {
        if (nameList.isEmpty()) {
            System.out.println(RED + "❌ No records to remove." + RESET);
            return;
        }
        
        String removedName = position.equals("first") ? nameList.getFirst() : nameList.getLast();
        
        // remove item based on chosen position
        if (position.equals("first")) {
            nameList.removeFirst();
            ageList.removeFirst();
            genderList.removeFirst();
        } else {
            nameList.removeLast();
            ageList.removeLast();
            genderList.removeLast();
        }

        // Call the updateFile method that write the new record into the txt file
        updateFile();
        System.out.println(GREEN + "✓ Record '" + removedName + "' removed successfully from " + position + " position." + RESET);
    }

    // Print all records
    private static void displayAllRecord() {
        System.out.println();
        if (nameList.isEmpty()) {
            System.out.println(YELLOW + "📝 No records found in the system." + RESET);
            return;
        }
        
        System.out.println(BOLD + CYAN + "╔══════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + CYAN + "║                        ALL RECORDS                            ║" + RESET);
        System.out.println(BOLD + CYAN + "╠══════════════════════════════════════════════════════════════╣" + RESET);
        
        // Print all content of the linkelist using for each loop
        int index = 0;
        for (String record : nameList) {
            System.out.printf(BOLD + CYAN + "║" + RESET + " %2d. %-15s | %-3s | %-6s" + BOLD + CYAN + "                    ║%n", 
                index + 1, record, ageList.get(index), genderList.get(index));
            index++;
        }
        System.out.println(BOLD + CYAN + "╚══════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(GREEN + "✓ Total records: " + nameList.size() + RESET);
    }

    // Display specific record
    private static void displaySpecificRecord(Scanner inputScanner) {
        if (nameList.isEmpty()) {
            System.out.println(YELLOW + "📝 No records available." + RESET);
            return;
        }
        
        System.out.println(YELLOW + "Available records: 1 to " + nameList.size() + RESET);
        
        while (true) {
            try {
                System.out.print(CYAN + "Enter record number to display: " + RESET);
                int index = inputScanner.nextInt();
                inputScanner.nextLine();

                if (index >= 1 && index <= nameList.size()) {
                    System.out.println();
                    System.out.println(BOLD + GREEN + "╔══════════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(BOLD + GREEN + "║                        RECORD #" + String.format("%-2d", index) + "                              ║" + RESET);
                    System.out.println(BOLD + GREEN + "╠══════════════════════════════════════════════════════════════╣" + RESET);
                    System.out.printf(BOLD + GREEN + "║" + RESET + " Name:   %-45s " + BOLD + GREEN + "║%n", nameList.get(index - 1) + RESET);
                    System.out.printf(BOLD + GREEN + "║" + RESET + " Age:    %-45s " + BOLD + GREEN + "║%n", ageList.get(index - 1) + RESET);
                    System.out.printf(BOLD + GREEN + "║" + RESET + " Gender: %-45s " + BOLD + GREEN + "║%n", genderList.get(index - 1) + RESET);
                    System.out.println(BOLD + GREEN + "╚══════════════════════════════════════════════════════════════╝" + RESET);
                    break;
                } else {
                    System.out.println(RED + "❌ Invalid record number. Please enter a number between 1 and " + nameList.size() + "." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "❌ Invalid input. Please enter a number between 1 and " + nameList.size() + "." + RESET);
                inputScanner.nextLine();
            }
        }
    }

    // Method that edit the record based on record number
    private static void editRecord(Scanner inputScanner) throws Exception {
        if (nameList.isEmpty()) {
            System.out.println(YELLOW + "📝 No records available to edit." + RESET);
            return;
        }
        
        System.out.println(YELLOW + "Available records: 1 to " + nameList.size() + RESET);
        
        try {
            System.out.print(CYAN + "Enter record number to edit: " + RESET);
            int index = inputScanner.nextInt();
            inputScanner.nextLine();

            // Condition that check if the inputted number is within the range of the linkedlist size
            if (index >= 1 && index <= nameList.size()) {
                index -= 1;
                System.out.println();
                System.out.println(BOLD + YELLOW + "=== EDITING RECORD #" + (index + 1) + " ===" + RESET);
                System.out.printf("Current: %s, %s, %s%n", nameList.get(index), ageList.get(index), genderList.get(index));
                System.out.println();

                // Prompt the user for new details
                System.out.println(YELLOW + "Enter new details (press Enter to keep current value):" + RESET);

                System.out.print("New name [" + nameList.get(index) + "]: ");
                String newName = inputScanner.nextLine().trim();
                if (!newName.isEmpty()) {
                    nameList.set(index, newName);
                }

                System.out.print("New age [" + ageList.get(index) + "]: ");
                String newAge = inputScanner.nextLine().trim();
                if (!newAge.isEmpty()) {
                    if (!newAge.matches("\\d+")) {
                        System.out.println(RED + "❌ Invalid age. Please enter a numeric value." + RESET);
                        return;
                    }
                    ageList.set(index, newAge);
                }

                System.out.print("New gender [" + genderList.get(index) + "] (Male/Female): ");
                String genderInput = inputScanner.nextLine().trim();
                if (!genderInput.isEmpty()) {
                    // Check if the input is valid
                    if (!genderInput.equalsIgnoreCase("male") && !genderInput.equalsIgnoreCase("female")) {
                        System.out.println(RED + "❌ Invalid gender. Please enter Male or Female." + RESET);
                        return;
                    }

                    // Format gender to become Sentence case (maLe -> Male or femAle -> Female)
                    String formattedGender = genderInput.substring(0, 1).toUpperCase()
                            + genderInput.substring(1).toLowerCase();
                    genderList.set(index, formattedGender);
                }

                // Call the updateFile method that write the new record into the txt file
                // (records.txt)
                updateFile();
                System.out.println(GREEN + "✓ Record updated successfully." + RESET);

            } else {
                System.out.println(RED + "❌ Invalid record number." + RESET);
            }
        } catch (InputMismatchException e) {
            System.err.println(RED + "❌ Invalid input. Please enter a number between 1 and " + nameList.size() + "." + RESET);
            inputScanner.nextLine();
            return;
        }
    }

    private static String getRecordInput(Scanner inputScanner, String recordType) {
        while (true) {
            System.out.print(CYAN + "Enter " + recordType + ": " + RESET);
            String input = inputScanner.nextLine().trim();
            
            if (recordType.equals("gender")) {
                if (!input.equalsIgnoreCase("male") && !input.equalsIgnoreCase("female")) {
                    System.out.println(RED + "❌ Invalid gender. Please enter Male or Female only." + RESET);
                    continue;
                }
                input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
            }
            // Check if age only have numeric value
            if (recordType.equals("age")) {
                if (!input.matches("\\d+")) {
                    System.out.println(RED + "❌ Invalid age. Please enter a numeric value." + RESET);
                    continue;
                }
            } else if (input.isEmpty()) {
                System.out.println(RED + "❌ Input cannot be empty." + RESET);
                continue;
            }
            return input;
        }
    }

    // Method that scan the 'records.txt' and add to value to linkedlist 
    private static void storeData(Scanner fileScanner, LinkedList<String> nameList, LinkedList<String> ageList, LinkedList<String> genderList) {
        int lineNumber = 0;
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine().trim();
            lineNumber++;
            if (!line.isEmpty()) {
                String[] token = line.split(",");

                // Check if line is invalid and skip it
                if (token.length != 3) {
                    System.out.println(YELLOW + "⚠️  Skipping invalid line " + lineNumber + ": " + line + RESET);
                    continue;
                }
                nameList.add(token[0]);
                ageList.add(token[1]);
                genderList.add(token[2]);
            }
        }
    }

    // Method to write to the txt file
    private static void updateFile() {
        try (FileWriter writer = new FileWriter("records.txt")) {
            for (int i = 0; i < nameList.size(); i++) {
                writer.write(nameList.get(i) + "," + ageList.get(i) + "," + genderList.get(i) + "\n");
            }
        } catch (Exception e) {
            System.out.println(RED + "❌ Error writing to file: " + e.getMessage() + RESET);
        }
    }
}
