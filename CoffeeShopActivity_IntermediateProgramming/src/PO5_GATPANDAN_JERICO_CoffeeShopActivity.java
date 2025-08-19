import java.util.ArrayList;
import java.util.Scanner;

public class PO5_GATPANDAN_JERICO_CoffeeShopActivity {
    static ArrayList<ArrayList<String>> products = new ArrayList<>();
    static ArrayList<ArrayList<String>> orders = new ArrayList<>();
    private static int productNumber = 1;
    private static int orderID = 1001;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        mainMenu(input);
    }

    private static void mainMenu(Scanner input) {
        while (true) {
            System.out.print("-".repeat(15));
            System.out.println("\n| Coffee Shop |");
            System.out.println("-".repeat(15));

            System.out.println(" 1. Add Product\n 2. Edit Product\n 3. Delete Product\n 4. Take Pre-Order\n 5. View Menu\n 6. View Order\n 7. Inventory\n 8. Exit\n");

            System.out.print("Enter your choice: ");
            String choiceStr = input.nextLine().trim();

            if (!choiceStr.matches("[1-8]")) {
                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                continue;
            }
            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    addProduct(input);
                    break;
                case 2:
                    editProduct(input);
                    break;
                case 3:
                    deleteProduct(input);
                    break;
                case 4:
                    takePreOrder(input);
                    break;
                case 5:
                    viewMenu();
                    break;
                case 6:
                    viewOrder();
                    break;
                case 7:
                    viewInventory();
                    break;
                case 8:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 8.");

            }
        }
    }


    private static void addProduct(Scanner input) {

        while (true) {
            ArrayList<String> product = new ArrayList<>();

            String ID = generateProductID(productNumber);
            System.out.println("\nProduct ID: " + ID);


            String productName;
            while (true) {
                System.out.print("Enter Product Name: ");
                productName = input.nextLine();
                if (isValidProduct(productName)) {
                    break;
                } else {
                    System.out.println("Invalid product name. Product already exist.");
                }
            }

            System.out.print("Enter the Product Ingredient (comma-separated): ");
            String productIngredient = input.nextLine();

            String productStatus;
            while (true) {
                System.out.print("Enter Product Status (0 or 1): ");
                productStatus = input.nextLine().trim();
                if (productStatus.matches("[01]")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 0 or 1.");
                }
            }

            String productPrice;
            while (true) {
                System.out.print("Enter Product price: ");
                productPrice = input.nextLine().trim();
                if (productPrice.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }

            productNumber++;

            product.add(ID);
            product.add(productName);
            product.add(productIngredient);
            product.add(productStatus);
            product.add(productPrice);

            products.add(product);

            while (true) {
                System.out.print("Would you like to add more? (Y/N): ");
                char choice = input.nextLine().toUpperCase().trim().charAt(0);

                if (choice == 'N') {
                    return;
                } else if (choice == 'Y') {
                    break;
                } else System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    private static void editProduct(Scanner input) {
        viewInventory();
        System.out.print("\nEnter Product ID or Name to edit: ");
        String idOrName = input.nextLine();

        for (ArrayList<String> product : products) {
            if (product.get(0).equalsIgnoreCase(idOrName) || product.get(1).equalsIgnoreCase(idOrName)) {
                System.out.println("Editing: " + product.get(0) + " - " + product.get(1));

                System.out.print("Enter new name (or press Enter to keep current): ");
                String newName = input.nextLine().trim();
                if (!newName.isEmpty()) {
                    product.set(1, newName);
                }

                System.out.print("Enter new ingredient (or press Enter to keep current): ");
                String newIngredient = input.nextLine().trim();
                if (!newIngredient.isEmpty()) {
                    product.set(2, newIngredient);
                }

                System.out.print("Enter new product status (0 or 1) (or press Enter to keep the current): ");
                String newStatus = input.nextLine().trim();
                if (!newStatus.isEmpty()) {
                    if (newStatus.equals("0") || newStatus.equals("1")) {
                        product.set(3, newStatus);
                    }
                }

                System.out.print("Enter new product price (or press Enter to keep current): ");
                String newPrice = input.nextLine().trim();
                if (!newPrice.isEmpty()) {
                    product.set(4, newPrice);
                }

                return;
            }
        }
        System.out.println("Product not found.\n");
    }

    private static void deleteProduct(Scanner input) {
        viewInventory();
        System.out.print("\nEnter Product ID or Name to delete: ");
        String idOrName = input.nextLine();

        for (ArrayList<String> product : products) {
            if (product.get(0).equalsIgnoreCase(idOrName) || product.get(1).equalsIgnoreCase(idOrName)) {
                products.remove(product);
                System.out.println("Product deleted successfully!\n");
                return;
            }
        }
        System.out.println("Product not found.\n");
    }

    private static void takePreOrder(Scanner input) {
        boolean isFirstOrder = true;
        String customerName = "";

        while (true) {
            ArrayList<String> order = new ArrayList<>();

            String ID = generateOrderID(orderID);
            System.out.println("Order ID: " + ID);

            if (isFirstOrder) {
                System.out.print("Enter Customer Name: ");
                customerName = input.nextLine();
                isFirstOrder = false;
            } else {
                System.out.println("Customer Name: " + customerName);
            }

            viewMenu();


            String orderName; // TODO Accept only if product is available
            while (true) {
                System.out.print("Enter Order Name: ");
                orderName = input.nextLine();
                if (isAvailableProduct(orderName)) {
                    break;
                } else {
                    System.out.println("Invalid product or out of stock. Please choose from the menu.");
                }
            }
            String orderQuantity;
            while (true) {
                System.out.print("Enter the quantity of the product: ");
                orderQuantity = input.nextLine();
                if (orderQuantity.matches("\\d+") && Double.parseDouble(orderQuantity) > 0) {
                    break;
                } else {
                    System.out.println("Invalid quantity. Please enter a valid quantity.");
                }
            }

            String sugarLevel;
            while (true) {
                System.out.print("Enter sugar level (0-100): ");
                sugarLevel = input.nextLine().trim();
                try {
                    int sugarLevelInt = Integer.parseInt(sugarLevel);
                    if (sugarLevelInt >= 0 && sugarLevelInt <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid sugar level. Please enter a number between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            order.add(ID);
            order.add(customerName);
            order.add(orderName);
            order.add(orderQuantity);
            order.add(sugarLevel);

            orders.add(order);
            while (true) {
                System.out.print("Would you like to order more? (Y/N): ");
                char choice = input.nextLine().toUpperCase().trim().charAt(0);

                if (choice == 'N') {
                    orderID++;
                    return;
                } else if (choice == 'Y') {
                    break;
                } else System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }

    }

    private static boolean isValidProduct(String productName) {
        for (ArrayList<String> product : products) {
            if (product.get(1).equalsIgnoreCase(productName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAvailableProduct(String productName) {
        for (ArrayList<String> product : products) {
            if (product.get(1).equalsIgnoreCase(productName) && product.get(3).equals("0")) {
                return true;
            }
        }
        return false;
    }

    private static void viewMenu() {
        int NAME_WIDTH = 14;
        int PRICE_WIDTH = 14;
        int STATUS_WIDTH = 14;
        int totalWidth = NAME_WIDTH + PRICE_WIDTH + STATUS_WIDTH + 14;
        String border = "-".repeat(totalWidth);

        String text = "MENU";
        int padding = (totalWidth - text.length()) / 2;
        String centeredText = String.format("%" + padding + "s%s%" + padding + "s", "", text, "");
        System.out.println(centeredText);

        System.out.println(border);
        System.out.printf("| %-" + NAME_WIDTH + "s | %-" + PRICE_WIDTH + "s | %-" + STATUS_WIDTH + "s |\n", "Products", "Price", "Status");
        System.out.println(border);

        for (ArrayList<String> product : products) {
            String productName = product.get(1);
            double price = Double.parseDouble(product.get(4));
            String formattedPrice = String.format("PHP %.2f", price);
            String status = product.get(3).equals("0") ? "Available" : "Not Available";

            System.out.printf("| %-" + NAME_WIDTH + "s | %-" + PRICE_WIDTH + "s | %-" + STATUS_WIDTH + "s |\n", productName, formattedPrice, status);
//            System.out.printf("| %" + ID_WIDTH + "s | %" + NAME_WIDTH + "s | %" + INGREDIENTS_WIDTH + "s | %" + STATUS_WIDTH + "s | %-" + PRICE_WIDTH + "s |\n", id, name, ingredients, status, formattedPrice);
        }
        System.out.println(border);


    }

    private static void viewOrder() {
        /* ORDER ID | CUSTOMER NAME | PRODUCT NAME | QUANTITY | SUGAR LEVEL | AMOUNT |  and compute the total price of each by quantity and compute for the total sum */
        int ID_WIDTH = 8;
        int CUSTOMER_NAME_WIDTH = 14;
        int PRODUCT_NAME_WIDTH = 14;
        int QUANTITY_WIDTH = 8;
        int SUGAR_LEVEL_WIDTH = 14;
        int AMOUNT_WIDTH = 16;
        int totalWidth = ID_WIDTH + CUSTOMER_NAME_WIDTH + PRODUCT_NAME_WIDTH + QUANTITY_WIDTH + SUGAR_LEVEL_WIDTH + AMOUNT_WIDTH + 16;
        String border = "-".repeat(totalWidth);

        System.out.println(border);
        System.out.printf("| %" + ID_WIDTH + "s | %" + CUSTOMER_NAME_WIDTH + "s | %" + PRODUCT_NAME_WIDTH + "s | %" + QUANTITY_WIDTH + "s | %" + SUGAR_LEVEL_WIDTH + "s | %" + AMOUNT_WIDTH + "s |\n",
                "Order ID", "Customer Name", "Product Name", "Quantity", "Sugar Level", "Amount");
        System.out.println(border);

        double totalSum = 0;

        for (ArrayList<String> order : orders) {
            String id = order.get(0);
            String customerName = order.get(1);
            String productName = order.get(2);
            int quantity = Integer.parseInt(order.get(3));
            String sugarLevel = order.get(4) + "%";
            double productPrice = getProductPrice(productName);
            double amount = productPrice * quantity;

            totalSum += amount;
            String formattedAmount = String.format("PHP %.2f", amount);

            System.out.printf("| %" + ID_WIDTH + "s | %" + CUSTOMER_NAME_WIDTH + "s | %" + PRODUCT_NAME_WIDTH + "s | %" + QUANTITY_WIDTH + "d | %" + SUGAR_LEVEL_WIDTH + "s | %" + AMOUNT_WIDTH + "s |\n", id, customerName, productName, quantity, sugarLevel, formattedAmount);
        }
        System.out.println(border);
        String text = "TOTAL";
        String formattedTotal = String.format("PHP %.2f", totalSum);
        int totalSumWidth = ID_WIDTH + CUSTOMER_NAME_WIDTH + PRODUCT_NAME_WIDTH + QUANTITY_WIDTH + SUGAR_LEVEL_WIDTH + 12;
        int padding = (totalSumWidth - text.length()) / 2;
        String paddedText = " ".repeat(padding) + text + " ".repeat(totalSumWidth - padding - text.length());
        System.out.printf("| %s | %" + AMOUNT_WIDTH + "s |\n", paddedText, formattedTotal);
        System.out.println(border);

    }

    private static double getProductPrice(String productName) {
        for (ArrayList<String> product : products) {
            if (product.get(1).equalsIgnoreCase(productName)) {
                return Double.parseDouble(product.get(4));
            }
        }
        return 0;
    }

    private static void viewInventory() {
        int ID_WIDTH = 8;
        int NAME_WIDTH = 14;
        int INGREDIENTS_WIDTH = 14;
        int STATUS_WIDTH = 14;
        int PRICE_WIDTH = 14;
        int totalWidth = ID_WIDTH + NAME_WIDTH + INGREDIENTS_WIDTH + STATUS_WIDTH + PRICE_WIDTH + 14;
        String border = "-".repeat(totalWidth);

        System.out.println();
        String text = "INVENTORY";
        int padding = (totalWidth - text.length()) / 2;
        String centeredText = String.format("%" + padding + "s%s%" + padding + "s", "", text, "");
        System.out.println(centeredText);

        System.out.println(border);
        System.out.printf("| %" + ID_WIDTH + "s | %" + NAME_WIDTH + "s | %" + INGREDIENTS_WIDTH + "s | %" + STATUS_WIDTH + "s | %" + PRICE_WIDTH + "s |\n",
                "ID", "Product Name", "Ingredients", "Status", "Price");
        System.out.println(border);

        for (ArrayList<String> product : products) {
            String id = product.get(0);
            String name = product.get(1);
            String ingredients = product.get(2);
            String status = product.get(3).equals("0") ? "Available" : "Not Available";
            double price = Double.parseDouble(product.get(4));
            String formattedPrice = String.format("PHP %.2f", price);

            System.out.printf("| %" + ID_WIDTH + "s | %" + NAME_WIDTH + "s | %" + INGREDIENTS_WIDTH + "s | %" + STATUS_WIDTH + "s | %-" + PRICE_WIDTH + "s |\n",
                    id, name, ingredients, status, formattedPrice);
        }
        System.out.println(border);
    }

    private static String generateProductID(int productID) {
        return String.format("%04d", productID);
    }

    private static String generateOrderID(int orderID) {
        return String.format("%04d", orderID);
    }
}
