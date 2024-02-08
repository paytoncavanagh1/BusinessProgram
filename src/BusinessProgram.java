import java.util.Scanner;

class Item {
    private String productName;
    private int quantity;  // Add quantity
    private String chosenColor;  // Add chosenColor
    private String chosenSize;  // Add chosenSize

    // Constructor and other methods
    Item(String productName, int quantity, String chosenColor, String chosenSize) {
        this.productName = productName;
        this.quantity = quantity;
        this.chosenColor = chosenColor;
        this.chosenSize = chosenSize;
    }

    // Getter methods
    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getChosenColor() {
        return chosenColor;
    }

    public String getChosenSize() {
        return chosenSize;
    }
}


public class BusinessProgram {

    // Class for the product
    static class Product {
        String productName;
        String[] color = {"Red", "Blue", "Yellow"};
        String[] size = {"S", "M", "L", "XL"};
        int quantity = 0;
        String chosenColor;
        String chosenSize;
        double price;
    }

    public static void main(String[] args) {
        // Array of Product objects
        Product[] fyve = new Product[5];

        // Initialize the products
        initializeFyve(fyve);

        // Set up product names and prices
        fyve[0].productName = "Snow Jacket";
        fyve[1].productName = "Snow Pants";
        fyve[2].productName = "Beanie";
        fyve[3].productName = "Crew Neck";
        fyve[4].productName = "Fleece";

        fyve[0].price = 75.00;
        fyve[1].price = 100.00;
        fyve[2].price = 25.00;
        fyve[3].price = 50.00;
        fyve[4].price = 50.00;

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to my Snow shop where we sell Fyve apparel.");

        // Set decimal places to two spots .00
        System.out.printf("%.2f", 0.0);

        int choice;

        do {
            choice = showMenu();

            switch (choice) {
                case 1:
                    showProducts(fyve);
                    break;

                case 2:
                    orderProducts(fyve);
                    break;

                case 3:
                    completeOrder(fyve);
                    break;

                case 4:
                    System.out.println("You chose to end the program.\n");
                    break;

                default:
                    break;
            }

        } while (isValid(choice));
    }

    // Initializes the products
    static void initializeFyve(Product[] f) {
        for (int i = 0; i < 5; i++) {
            f[i] = new Product();
            f[i].productName = "";
            f[i].quantity = 0;
            f[i].price = 0;
        }
    }

    // Show main menu
    static int showMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nHello! I will show you a menu with 4 options. Please choose between 1-4. If you would like to order multiple items, I will re-display the menu after you are done ordering. Once you finish your order, select the 'quit' option to see your total price.\n");

        // Menu for Fyve
        System.out.printf("%-20s%s%n", "1: Show Products", "");
        System.out.printf("%-20s%s%n", "2: Order Products", "");
        System.out.printf("%-20s%s%n", "3: Complete Order", "");
        System.out.printf("%-10s%s%n", "4: Quit", "");
        choice = scanner.nextInt();
        System.out.println();

        // Input validation
        while (!isValid(choice, 1, 4)) {
            System.out.println("Please choose an option from the menu.\n");
            choice = scanner.nextInt();
            System.out.println();
        }

        return choice;
    }

    // Show product descriptions (1 On the main menu)
    static int showProducts(Product[] f) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("In the show products tab, I will show a description of the item you decide to choose. Please choose from the five options given (1-5):\n");
        System.out.printf("%-5s%s%n", "1:", f[0].productName + " $" + f[0].price);
        System.out.printf("%-5s%s%n", "2:", f[1].productName + " $" + f[1].price);
        System.out.printf("%-5s%s%n", "3:", f[2].productName + " $" + f[2].price);
        System.out.printf("%-5s%s%n", "4:", f[3].productName + " $" + f[3].price);
        System.out.printf("%-5s%s%n", "5:", f[4].productName + " $" + f[4].price);
        choice = scanner.nextInt();
        System.out.println();

        // Input validation
        while (!isValid(choice, 1, 5)) {
            System.out.println("Please choose an option from the menu.\n");
            choice = scanner.nextInt();
            System.out.println();
        }

        switch (choice) {
            case 1:
                // Description of Snow Jacket
                System.out.println("The Snow Jackets from Fyve are an all mountain jacket providing warmth in weather below 30 degrees. The jacket comes in three different colors including Red, Blue, and Yellow. The jacket also comes in four different sizes including S, M, L, and XL. This jacket comes in at the price of $75.00.\n");
                break;

            case 2:
                // Description of Snow Pants
                System.out.println("The Snow Pants from Fyve are more park-oriented pants suiting more snowboarders who enjoy hitting up the terrain park. These pants come in three different colors including Red, Blue, and Yellow. The pants also come in four different sizes including S, M, L, and XL. These pants come in at the price of $100.00.\n");
                break;

            case 3:
                // Description of Beanies
                System.out.println("The Beanies sold by Fyve are very warm and comfortable and will keep your head and ears warm all day. These beanies come in three different colors including Red, Blue, and Yellow. The beanies also come in four different sizes including S, M, L, and XL. These beanies come in at the price of $25.00.\n");
                break;

            case 4:
                // Description of Crew Necks
                System.out.println("The Crew Necks sold by Fyve fit loose and are the most comfortable piece of clothing you will ever wear. These crew necks come in three different colors including Red, Blue, and Yellow. The crew necks also come in four different sizes including S, M, L, and XL. These crew necks come in at the price of $50.00.\n");
                break;

            case 5:
                // Description of Fleece
                System.out.println("The Fleece's sold by Fyve use all cotton creating a pillow to wear. The Fleece's fit tight in order to keep our customers warm. These fleece's come in three different colors including Red, Blue, and Yellow. The fleece's also come in four different sizes including S, M, L, and XL. These fleece's come in at the price of $50.00.\n");
                break;

            default:
                break;
        }

        return choice;
    }

    // Order product page (2 On the main menu)
    static void orderProducts(Product[] f) {
        char choice;
        int product;
        Scanner scanner = new Scanner(System.in);
        String chosenColor = "";
        String chosenSize = "";

        // Listing the five products available to purchase
        System.out.println("These are the five products you are able to purchase. Please choose the one that you would like to buy.\n");
        System.out.printf("%-5s%s%n", "1:", f[0].productName);
        System.out.printf("%-5s%s%n", "2:", f[1].productName);
        System.out.printf("%-5s%s%n", "3:", f[2].productName);
        System.out.printf("%-5s%s%n", "4:", f[3].productName);
        System.out.printf("%-5s%s%n", "5:", f[4].productName);
        choice = scanner.next().charAt(0);
        System.out.println();

        // Input validation
        while (!isValid(choice, '1', '5')) {
            System.out.println("Please choose an option from the menu.\n");
            choice = scanner.next().charAt(0);
            System.out.println();
        }

        // This has to do with the ASCII table and turning char into an int
        // -1 at the end is because the array of items you can buy is 0-indexed
        // product = choice - '0' - 1;

        // Asking the user how many of this one item they would like to purchase
        System.out.println("How many of this item would you like? (1-4)\n");
        int quantity = scanner.nextInt();
        // choice = scanner.next().charAt(0);
        System.out.println();

        // Input validation
        while (!isValid(choice, '1', '4')) {
            System.out.println("Please choose an option from the menu.\n");
            quantity = scanner.nextInt();
            // choice = scanner.next().charAt(0);
            System.out.println();
        }

        // Quantity is an int and choice is a char, - '0' is for the ASCII table to make the numbers line up
        // f[product].quantity = choice - '0';
        product = choice - '0' - 1;

        // Listing the different colors to choose from
        System.out.println("Which color would you like to choose for this item?\n");
        System.out.printf("%-5s%s%n", "1:", f[0].color[0]);
        System.out.printf("%-5s%s%n", "2:", f[0].color[1]);
        System.out.printf("%-5s%s%n", "3:", f[0].color[2]);
        choice = scanner.next().charAt(0);
        System.out.println();

        // Input validation
        while (!isValid(choice, '1', '3')) {
            System.out.println("Please choose an option from the menu.\n");
            choice = scanner.next().charAt(0);
            System.out.println();
        }

        // Setting variable, chosenColor, equal to the color chosen in order to be able to display it in the receipt
        if (choice == '1') {
            // f[product] represents the product that the user chose
            f[product].chosenColor = "Red";
            chosenColor = "Red";
        } else if (choice == '2') {
            f[product].chosenColor = "Blue";
            chosenColor = "Blue";
        } else {
            f[product].chosenColor = "Yellow";
            chosenColor = "Yellow";
        }

        // Listing different sizes available for each item
        System.out.println("What size would you like this item?\n");
        System.out.printf("%-5s%s%n", "1:", f[0].size[0]);
        System.out.printf("%-5s%s%n", "2:", f[0].size[1]);
        System.out.printf("%-5s%s%n", "3:", f[0].size[2]);
        System.out.printf("%-5s%s%n", "4:", f[0].size[3]);
        choice = scanner.next().charAt(0);
        System.out.println();

        // Input validation
        while (!isValid(choice, '1', '4')) {
            System.out.println("Please choose an option from the menu.\n");
            choice = scanner.next().charAt(0);
            System.out.println();
        }

        // Setting chosenSize = the size chosen by the user in order to display it in receipt
        switch (choice) {
            case '1':
                f[product].chosenSize = "S";
                chosenSize = "S";
                break;
            case '2':
                f[product].chosenSize = "M";
                chosenSize = "M";
                break;
            case '3':
                f[product].chosenSize = "L";
                chosenSize = "L";
                break;
            case '4':
                f[product].chosenSize = "XL";
                chosenSize = "XL";
                break;
        }

         // Accumulate the quantity and update the chosen size and color
        f[product].quantity += quantity;
        f[product].chosenColor = chosenColor;
        f[product].chosenSize = chosenSize;

        // Product item = new Item(f[productproductName, quantity, chosenColor, chosenSize);
    }

    // Function to complete the order
    static void completeOrder(Product[] f) {
        // Constants and variables
        final double TAX = 0.0875;
        double shippingFee = 8.75;
        double total = 0;
        double tax;
        char choice;

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Asking the user if they want to pick up item in person or get it shipped
        System.out.println("Would you like to pick up in person, or would you like shipping?\n");
        System.out.printf("%-5s%s%n", "1:", "Pick-up");
        System.out.printf("%-5s%s%n", "2:", "Shipping");
        choice = scanner.next().charAt(0);
        System.out.println();

        // Input validation
        while (!isValid(choice, '1', '2')) {
            System.out.println("Please choose an option from the menu.\n");
            choice = scanner.next().charAt(0);
            System.out.println();
        }

        // If the user chooses option 1, no shipping fee is added
        if (choice == '1') {
            shippingFee = 0;
        }

        // Getting the price of all products depending on quantity
        for (int i = 0; i < 5; i++) {
            total += f[i].price * f[i].quantity;
        }

        // If the total price is greater than or equal to 50, then no shipping fee
        if (total >= 50) {
            shippingFee = 0;
        }

        // Calculating total and tax
        total += shippingFee;
        tax = total * TAX;
        total = total + tax;

        // Receipt page
        System.out.println("-------------------------------------------------");
        System.out.printf("%-5s%-20s%-10s%-8s%-10s%n", "QTY", "Description", "Color", "Size", "Price");
        System.out.println("-------------------------------------------------");

        // Displaying the items that were ordered
        for (int i = 0; i < 5; i++) {
            if (f[i].quantity > 0) {
                System.out.printf("%-5d%-20s%-10s%-8s%-10.2f%n", f[i].quantity, f[i].productName, f[i].chosenColor, f[i].chosenSize, f[i].price * f[i].quantity);
            }
        }

        System.out.println("-------------------------------------------------");


        // Shipping fee is shown if it is applied to the bill, otherwise it is hidden
        System.out.println(shippingFee != 0 ? "Shipping Fee: " + shippingFee : "Shipping Fee: 0");

        // Showing tax and total
        System.out.printf("Tax: %.2f%nTotal: %.2f%n", tax, total);
    }

    // All boolean functions to help validate input from the user
    static boolean isValid(int num, int min, int max) {
        return num >= min && num <= max;
    }

    static boolean isValid(char num, char min, char max) {
        return num >= min && num <= max;
    }

    static boolean isValid(int c) {
        return c != 4;
    }
}
