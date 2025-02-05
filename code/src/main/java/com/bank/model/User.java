package com.bank.model;

public abstract class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }
}

