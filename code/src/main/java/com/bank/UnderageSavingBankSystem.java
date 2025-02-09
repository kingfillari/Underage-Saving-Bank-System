package com.bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.bank.model.*;
import com.bank.model.UserAuthenticator;
import com.bank.model.AdminAuthenticator;
import java.util.ArrayList;
import java.util.List;

public class UnderageSavingBankSystem {
    private List<User> users;
    private List<Account> accounts;
    private static final String USER_DATA_FILE = "users.txt"; // File to store user data
    private static final String ACCOUNT_DATA_FILE = "accounts.txt"; // File to store account data
    private AdminAuthenticator adminAuth;

    public UnderageSavingBankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.adminAuth = new AdminAuthenticator("admin", "admin123"); // Set admin credentials
    }

    public void addUser (User user) {
        users.add(user);
        saveUserToFile(user); // Save user to file
    }

    private void saveUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE, true))) {
            writer.write(user.getUserId() + "," + user.getName());
            writer.newLine();
            System.out.println("User  saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving user to file: " + e.getMessage());
        }
    }

    public void createAccount(Child child) {
        String accountId = "ACC" + (accounts.size() + 1);
        Account account = new Account(accountId, child);
        accounts.add(account);
        saveAccountToFile(account); // Save account to file
    }

    private void saveAccountToFile(Account account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNT_DATA_FILE, true))) {
            writer.write(account.getAccountId() + "," + account.getOwner().getUserId());
            writer.newLine();
            System.out.println("Account saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving account to file: " + e.getMessage());
        }
    }

    public void listUsers() {
        System.out.println("List of Users:");
        for (User  user : users) {
            System.out.println("ID: " + user.getUserId() + ", Name: " + user.getName());
        }
    }

    public void addNewUser (Scanner scanner) {
        System.out.print("Enter new user's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new user's ID: ");
        String id = scanner.nextLine();

        User newUser  = new Parent(name, id); // Assuming User is a Parent for simplicity
        addUser (newUser );
        System.out.println("New user added successfully.");
    }

    public void userRegistration(Scanner scanner, User user) {
        System.out.print("Enter child's name: ");
        String childName = scanner.nextLine();
        System.out.print("Enter child's ID: ");
        String childId = scanner.nextLine();
        System.out.print("Enter child's age: ");
        int childAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Child child = new Child(childName, childId, childAge);
        ((Parent) user).addChild(child); // Assuming user is a Parent
        createAccount(child); // Create account for the child
        System.out.println("Registration completed successfully.");
    }

    public void makeTransaction(Scanner scanner, Child child) {
        Account childAccount = getAccountForChild(child);
        if (childAccount != null) {
            System.out.print("Enter amount to deposit into child's account: ");
            double depositAmount = scanner.nextDouble();
            childAccount.deposit(depositAmount);
            System.out.println("Deposited $" + depositAmount + " into account.");
            System.out.println("New balance: $" + childAccount.getBalance());
        } else {
            System.out.println("No account found for child: " + child.getName());
        }
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
        UserAuthenticator userAuth = new UserAuthenticator();
        Scanner scanner = new Scanner(System.in);

        // Prompt for login type
        System.out.println("Login as:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.print("Choose an option (1 or 2): ");
        int loginType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (loginType == 1) {
            // Admin login
            System.out.println("Admin Login");
            System.out.print("Enter admin username: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Enter admin password: ");
            String adminPassword = scanner.nextLine();

            if (system.adminAuth.authenticate(adminUsername, adminPassword)) {
                System.out.println("Admin login successful!");

                // Admin actions
                boolean adminSessionActive = true;
                while (adminSessionActive) {
                    System.out.println("1. View Users");
                    System.out.println("2. Add New User");
                    System.out.println("3. Exit Admin");
                    System.out.print("Choose an option: ");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (adminChoice) {
                        case 1:
                            system.listUsers();
                            break;
                        case 2:
                            system.addNewUser (scanner);
                            break;
                        case 3:
                            adminSessionActive = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid admin credentials. Exiting.");
                return;
            }
        } else if (loginType == 2) {
            // User login and registration
            System.out.println("User  Login");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Here you can add logic to check if the user exists in the file
            // For simplicity, we will assume the user does not exist and proceed to registration
            System.out.println("User  does not exist. Proceeding to registration.");
            User newUser  = new Parent(username, "PARENT_ID"); // Replace with actual user ID logic
            system.addUser (newUser ); // Add user to the system
            system.userRegistration(scanner, newUser );

            // Make a transaction
            System.out.print("Enter child's name for transaction: ");
            String childNameForTransaction = scanner.nextLine();
            Child childForTransaction = newUser .getChildByName(childNameForTransaction); // Assuming a method to get child by name
            system.makeTransaction(scanner, childForTransaction);
        } else {
            System.out.println("Invalid option. Exiting.");
        }

        scanner.close(); // Close the scanner
    }
}