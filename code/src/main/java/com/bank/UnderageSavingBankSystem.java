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

        // Create user: Child with input validation
        String childName = "";
        String childId = "";
        int childAge = 0;

        try {
            System.out.print("Enter child's name: ");
            childName = scanner.nextLine();
            System.out.print("Enter child's ID: ");
            childId = scanner.nextLine();
            System.out.print("Enter child's age: ");
            childAge = Integer.parseInt(scanner.nextLine()); // Ensure an integer is entered
            Child child = new Child(childName, childId, childAge);
            parent.addChild(child);

            system.addUser(parent);
            system.addUser(child);

            // Create account for child
            system.createAccount(child);

            // Create savings goal with input validation
            String goalName = "";
            double targetAmount = 0;

            System.out.print("Enter savings goal name: ");
            goalName = scanner.nextLine();
            System.out.print("Enter savings goal target amount: ");
            targetAmount = Double.parseDouble(scanner.nextLine()); // Ensure a valid double is entered
            SavingsGoal goal = new SavingsGoal(goalName, targetAmount);
            child.addSavingsGoal(goal);

            // Add educational module with input validation
            String moduleName = "";
            String moduleDescription = "";
            int moduleDuration = 0;

            System.out.print("Enter educational module name: ");
            moduleName = scanner.nextLine();
            System.out.print("Enter educational module description: ");
            moduleDescription = scanner.nextLine();
            System.out.print("Enter educational module duration (in hours): ");
            moduleDuration = Integer.parseInt(scanner.nextLine()); // Ensure an integer is entered
            EducationalModule module = new EducationalModule(moduleName, moduleDescription, moduleDuration);
            system.addEducationalModule(module);

            // Simulate some activities with input validation for deposit
            Account childAccount = system.getAccountForChild(child);
            if (childAccount != null) {
                double depositAmount = 0;
                try {
                    System.out.print("Enter amount to deposit into child's account: ");
                    depositAmount = Double.parseDouble(scanner.nextLine()); // Ensure a valid double is entered
                    childAccount.deposit(depositAmount);
                    goal.addSavings(depositAmount);
                    child.completeEducationalModule(module);

                    // Print account balance
                    System.out.println("Account balance for " + child.getName() + ": $" + childAccount.getBalance());
                    System.out.println("Progress towards " + goal.getName() + ": $" + goal.getCurrentAmount() + " / $" + goal.getTargetAmount());
                    System.out.println("Completed modules: " + child.getCompletedModules().size());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid deposit amount.");
                }
            } else {
                System.out.println("No account found for child: " + child.getName());
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number for age or other numeric values.");
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
