import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Create the mainframe
        JFrame frame = new JFrame("iKe Retail Services");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the input components
        JLabel nameLabel = new JLabel("Customer's Name:");
        JTextField nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Home Phone Number:");
        JTextField phoneField = new JTextField();
        JButton calculateButton = new JButton("Enter");

        // Create the output component
        JTextArea invoiceArea = new JTextArea();
        invoiceArea.setEditable(false);

        // Add the input components to a panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(calculateButton);

        // Add the input panel and output area to the mainframe
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(invoiceArea), BorderLayout.CENTER);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the input values
                String customerName = nameField.getText();
                String homePhone = phoneField.getText();

                // Perform calculations and generate the invoice
                double priceOneShirt = 0.0;
                double priceAPairOfPants = 0.0;
                double priceOneDress = 0.0;
                int numberofShirts = 0;
                int numberOfPants = 0;
                int numberOfDresses = 0;
                short orderMonth = 0;
                short orderDay = 0;
                short orderYear = 0;
                int totalNumberOfItems = 0;
                double subTotalShirts = 0.0;
                double subTotalPants = 0.0;
                double subTotalDresses = 0.0;
                double totalOrder = 0.0;
                final double discountRate = 0.15;

                try {
                    // Input price details
                    priceOneShirt = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of one shirt: "));
                    priceAPairOfPants = Double.parseDouble(JOptionPane.showInputDialog("Enter price for a pair of pants: "));
                    priceOneDress = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of one dress: "));

                    // Input number of items bought
                    numberOfPants = Integer.parseInt(JOptionPane.showInputDialog("Enter number of pants bought: "));
                    numberofShirts = Integer.parseInt(JOptionPane.showInputDialog("Enter number of shirts bought: "));
                    numberOfDresses = Integer.parseInt(JOptionPane.showInputDialog("Enter number of dresses bought: "));

                    // Input calendar details
                    orderMonth = Short.parseShort(JOptionPane.showInputDialog("Enter month number: "));
                    orderDay = Short.parseShort(JOptionPane.showInputDialog("Enter Day-number: "));
                    orderYear = Short.parseShort(JOptionPane.showInputDialog("Enter year: "));

                    // Perform calculations
                    totalNumberOfItems = numberofShirts + numberOfPants + numberOfDresses;
                    subTotalShirts = numberofShirts * priceOneShirt;
                    subTotalPants = numberOfPants * priceAPairOfPants;
                    subTotalDresses = numberOfDresses * priceOneDress;
                    totalOrder = subTotalShirts + subTotalPants + subTotalDresses;

                    // Generate the invoice
                    String invoice = "-/-\tiKe Retail Services\t-/-\n" +
                            "==============================================\n" +
                            "Customer: " + customerName + "\n" +
                            "Contact Number: " + homePhone + "\n" +
                            "Order Date: " + orderDay + "/" + orderMonth + "/" + orderYear + "\n" +
                            "----------------------------------------------------\n" +
                            "Items\tQty\tUnit/Price\tSub-Total\n" +
                            "Shirts\t" + numberofShirts + "\t$" + priceOneShirt + "\t\t $" + subTotalShirts + "\n" +
                            "Pants\t" + numberOfPants + "\t$" + priceAPairOfPants + "\t \t$" + subTotalPants + "\n" +
                            "Dresses\t" + numberOfDresses + "\t$" + priceOneDress + "\t \t$" + subTotalDresses + "\n" +
                            "--------------------------------------------------------\n" +
                            "Number of Items: " + totalNumberOfItems + "\n" +
                            "Total Order: $" + totalOrder + "\n" +
                            "Total Discount: $" + (totalOrder * discountRate) + "\n" +
                            "========================================================\n\n";

                    invoiceArea.setText(invoice);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter numeric values.");
                }
            }
        });

        // Set the mainframe visible
        frame.setVisible(true);
    }
}
