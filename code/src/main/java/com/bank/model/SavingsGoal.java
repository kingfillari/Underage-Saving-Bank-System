package com.bank.model;

public class SavingsGoal {
    private String name;
    private double targetAmount;
    private double currentAmount;

    public SavingsGoal(String name, double targetAmount) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = 0.0;
    }

    public void addSavings(double amount) {
        currentAmount += amount;
        if (currentAmount >= targetAmount) {
            System.out.println("Congratulations! You've reached your savings goal for " + name);
        }
    }

    public String getName() { return name; }
    public double getTargetAmount() { return targetAmount; }
    public double getCurrentAmount() { return currentAmount; }
}

