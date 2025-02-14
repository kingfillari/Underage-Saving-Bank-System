package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Child extends User {
    private int age;
    private List<SavingsGoal> savingsGoals;
    private List<EducationalModule> completedModules;

    public Child(String name, String userId, int age) {
        super(name, userId);
        this.age = age;
        this.savingsGoals = new ArrayList<>();
        this.completedModules = new ArrayList<>();
    }

    public void addSavingsGoal(SavingsGoal goal) {
        savingsGoals.add(goal);
    }

    public void completeEducationalModule(EducationalModule module) {
        completedModules.add(module);
    }

    public int getAge() {
        return age;
    }

    public List<SavingsGoal> getSavingsGoals() {
        return savingsGoals;
    }

    public List<EducationalModule> getCompletedModules() {
        return completedModules;
    }
}
