package org.example;
import org.example.Models.Bill;
import org.example.Models.Operations;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations operation = new Operations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View All Bills\n2. Add Bill\n3. Update Bill\n4. Delete Bill\n5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Bill> allBills = operation.getAllBills();
                    for (Bill bill : allBills) {
                        System.out.println(bill);
                    }
                    break;
                case 2:
                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();

                    Bill newBill = new Bill();
                    newBill.setItemName(itemName);
                    newBill.setAmount(amount);

                    operation.addBill(newBill);
                    System.out.println("Bill added successfully!");
                    break;
                case 3:
                    System.out.print("Enter Bill ID to update: ");
                    int billIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Bill billToUpdate = new Bill();
                    billToUpdate.setBillId(billIdToUpdate);

                    System.out.print("Enter new Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter new Amount: ");
                    amount = scanner.nextDouble();

                    billToUpdate.setItemName(itemName);
                    billToUpdate.setAmount(amount);

                    operation.updateBill(billToUpdate);
                    System.out.println("Bill updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter Bill ID to delete: ");
                    int billIdToDelete = scanner.nextInt();
                    operation.deleteBill(billIdToDelete);
                    System.out.println("Bill deleted successfully!");
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}