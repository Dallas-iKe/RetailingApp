import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double priceOneShirt;
        double priceAPairOfPants;
        String customerName, homePhone;
        int numberofShirts, numberOfPants, numberOfDresses;
        double priceOneDress;
        int totalNumberOfItems;
        double subTotalShirts, subTotalPants, subTotalDresses;
        short orderMonth, orderDay, orderYear;
        double totalOrder;

        final double discountRate = 0.15;

        Scanner sc = new Scanner(System.in); // sc is an object of the Scanner class

        // Input customer details

        System.out.println("Welcome to iKe Retail Services");
        System.out.print("Please enter customer's name: ");
        // Leave after name to make writing clear
        customerName = sc.nextLine();
        System.out.print("Please enter customer's home phone number:");
        homePhone = sc.nextLine();

        // Input price details
        System.out.print("\nEnter the price of one shirt: ");
        priceOneShirt = sc.nextDouble();
        System.out.print("Enter price for a pair of pants: ");
        priceAPairOfPants = sc.nextDouble();
        System.out.print("Enter the price of one dress: ");
        priceOneDress = sc.nextDouble();

        // Input number of items bought
        System.out.print("Enter number of pants bought: ");
        numberOfPants = sc.nextInt();
        System.out.print("Enter number of shirts bought: ");
        numberofShirts = sc.nextInt();
        System.out.print("Enter number of dresses bought: ");
        numberOfDresses = sc.nextInt();

        // Input calendar details
        System.out.println("\nEnter details of transaction date below");
        System.out.println("************************************************");
        System.out.print("Enter month: ");
        orderMonth = sc.nextShort();
        System.out.print("Enter Day: ");
        orderDay = sc.nextShort();
        System.out.print("Enter year: ");
        orderYear = sc.nextShort();

        // Perform calculations
        totalNumberOfItems = numberofShirts + numberOfPants + numberOfDresses;
        subTotalShirts = numberofShirts * priceOneShirt;
        subTotalPants = numberOfPants * priceAPairOfPants;
        subTotalDresses = numberOfDresses * priceOneDress;
        totalOrder = subTotalShirts + subTotalPants + subTotalDresses;

        // Display Invoice
        System.out.println("\n-/-\tiKe Retail Services\t-/-");
        System.out.println("==============================================");
        System.out.println("Customer: " + customerName);
        System.out.println("Contact Number: " + homePhone);
        System.out.println("Order Date: " + orderDay + "/" + orderMonth + "/" + orderYear);
        System.out.println("----------------------------------------------------");
        System.out.println("Items\tQty\tUnit/Price\tSub-Total");
        System.out.println("Shirts\t" + numberofShirts + "\t$" + priceOneShirt + "\t\t $" + subTotalShirts);
        System.out.println("Pants\t" + numberOfPants + "\t$" + priceAPairOfPants + "\t \t$" + subTotalPants);
        System.out.println("Dresses\t" + numberOfDresses + "\t$" + priceOneDress + "\t \t$" + subTotalDresses);
        System.out.println("--------------------------------------------------------");
        System.out.println("Number of Items: " + totalNumberOfItems);
        System.out.println("Total Order: $" + totalOrder);
        System.out.println("Total Discount: $" + (totalOrder * discountRate));
        System.out.println("========================================================");
        System.out.println();

        sc.close(); // Close the Scanner object
    }
}
