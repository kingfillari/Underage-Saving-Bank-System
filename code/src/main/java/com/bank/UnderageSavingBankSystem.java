package com.bank;
import java.util.Scanner;
import com.bank.model.*;
import java.util.ArrayList;
import java.util.List;

public class UnderageSavingBankSystem {
    private List<User> users;
    private List<Account> accounts;
    private List<EducationalModule> educationalModules;

    public UnderageSavingBankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.educationalModules = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void createAccount(Child child) {
        String accountId = "ACC" + (accounts.size() + 1);
        Account account = new Account(accountId, child);
        accounts.add(account);
    }

    public void addEducationalModule(EducationalModule module) {
        educationalModules.add(module);
    }

    public Account getAccountForChild(Child child) {
        for (Account account : accounts) {
            if (account.getOwner().equals(child)) {
                return account;
            }
        }
        return null;
    }

    
        public static void main(String[] args) {
            UnderageSavingBankSystem system = new UnderageSavingBankSystem();
            Scanner scanner = new Scanner(System.in);
    
            // Create user: Parent
            System.out.print("Enter parent's name: ");
            String parentName = scanner.nextLine();
            System.out.print("Enter parent's ID: ");
            String parentId = scanner.nextLine();
            Parent parent = new Parent(parentName, parentId);
    
            // Create user: Child
            System.out.print("Enter child's name: ");
            String childName = scanner.nextLine();
            System.out.print("Enter child's ID: ");
            String childId = scanner.nextLine();
            System.out.print("Enter child's age: ");
            int childAge = scanner.nextInt();
            Child child = new Child(childName, childId, childAge);
            parent.addChild(child);
    
            system.addUser (parent);
            system.addUser (child);
    
            // Create account for child
            system.createAccount(child);
    
            // Create savings goal
            System.out.print("Enter savings goal name: ");
            scanner.nextLine(); // Consume newline
            String goalName = scanner.nextLine();
            System.out.print("Enter savings goal target amount: ");Wubet
            double targetAmount = scanner.nextDouble();
            SavingsGoal goal = new SavingsGoal(goalName, targetAmount);
            child.addSavingsGoal(goal);
    
            // Add educational module
            System.out.print("Enter educational module name: ");
            scanner.nextLine(); // Consume newline
            String moduleName = scanner.nextLine();
            System.out.print("Enter educational module description: ");
            String moduleDescription = scanner.nextLine();
            System.out.print("Enter educational module duration (in hours): ");
            int moduleDuration = scanner.nextInt();
            EducationalModule module = new EducationalModule(moduleName, moduleDescription, moduleDuration);
            system.addEducationalModule(module);
    
            // Simulate some activities
            Account childAccount = system.getAccountForChild(child);
            if (childAccount != null) {
                System.out.print("Enter amount to deposit into child's account: ");
                double depositAmount = scanner.nextDouble();
                childAccount.deposit(depositAmount);
                goal.addSavings(depositAmount);
                child.completeEducationalModule(module);
    
                // Print account balance
                System.out.println("Account balance for " + child.getName() + ": $" + childAccount.getBalance());
                System.out.println("Progress towards " + goal.getName() + ": $" + goal.getCurrentAmount() + " / $" + goal.getTargetAmount());
                System.out.println("Completed modules: " + child.getCompletedModules().size());
            } else {
                System.out.println("No account found for child: " + child.getName());
            }
    
            scanner.close(); // Close the scanner
        }
    }


// private static void showAdminMenu() {
//     System.out.println("\nAdmin Menu:");
//     System.out.println("1. Add Product");
//     System.out.println("2. Edit Product");
//     System.out.println("3. Delete Product");
//     System.out.println("4. View All Orders");
//     System.out.println("5. Update Order Status");
//     System.out.println("6. Logout");
//     System.out.println("7. Exit");
//     System.out.print("Enter your choice: ");
//     try {
//         int choice = Integer.parseInt(scanner.nextLine());
//         // ths is rule switch same as switch but with simple syntex.
//         switch (choice) {
//             case 1 -> addProduct();
//             case 2 -> editProduct();
//             case 3 -> deleteProduct();
//             case 4 -> displayAllOrders();
//             case 5 -> updateOrderStatus();
//             case 6 -> logout();
//             case 7 -> exit();
//             default -> System.out.println("Invalid choice. Please select a valid option.");
//         }
//     } catch (NumberFormatException e) {
//         System.out.println("Error: Invalid input. Please enter a number.");
//     }
// }