package com.bank;

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
        System.out.println("User added: " + user.getName());
    }

    public List<User> getUsers() {
        return users;
    }
    

    public void createAccount(Child child) {
        String accountId = "ACC" + (accounts.size() + 1);
        Account account = new Account(accountId, child);
        accounts.add(account);
        System.out.println("Account created for child: " + child.getName() + " (Account ID: " + accountId + ")");
    }

    public void addEducationalModule(EducationalModule module) {
        educationalModules.add(module);
        System.out.println("Educational module added: " + module.getTitle());
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

        // Create users with Ethiopian names
        Parent parent = new Parent("Abebe Bekele", "P001");
        Child child = new Child("Kidus Abebe", "C001", 10);
        parent.addChild(child);

        system.addUser(parent);
        system.addUser(child);

        // Create account for child
        system.createAccount(child);

        // Create savings goal
        SavingsGoal goal = new SavingsGoal("New Bicycle", 100.0);
        child.addSavingsGoal(goal);
        System.out.println("Savings goal set: " + goal.getName() + " (Target: $" + goal.getTargetAmount() + ")");

        // Add educational module
        EducationalModule module = new EducationalModule("Budgeting Basics", "Learn how to create a simple budget", 10);
        system.addEducationalModule(module);

        // Simulate some activities
        Account childAccount = system.getAccountForChild(child);
        if (childAccount != null) {
            childAccount.deposit(50.0);
            goal.addSavings(50.0);
            child.completeEducationalModule(module);

            // Print account balance and progress
            System.out.println("\nSummary for " + child.getName() + ":");
            System.out.println("- Account ID: " + childAccount.getAccountId());
            System.out.println("- Current Balance: $" + childAccount.getBalance());
            System.out.println("- Savings Goal: " + goal.getName());
            System.out.println("  - Saved: $" + goal.getCurrentAmount() + " / $" + goal.getTargetAmount());
            System.out.println("- Completed Modules: " + child.getCompletedModules().size());
        } else {
            System.out.println("No account found for child: " + child.getName());
        }
    }
}