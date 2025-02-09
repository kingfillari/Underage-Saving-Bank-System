package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private List<Child> children;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public Child getChildByName(String childName) {
        for (Child child : children) {
            if (child.getName().equals(childName)) {
                return child;
            }
        }
        return null; // Child not found
    }
}