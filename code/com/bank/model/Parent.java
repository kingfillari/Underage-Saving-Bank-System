package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Parent extends User {
    private List<Child> children;

    public Parent(String name, String userId) {
        super(name, userId);
        this.children = new ArrayList<>();
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public void approveTransaction(Transaction transaction) {
        transaction.setApproved(true);
    }

    public List<Child> getChildren() { return children; }
}

