package com.bank.model;

public class AdminAuthenticator {
    private String adminUsername;
    private String adminPassword;

    public AdminAuthenticator(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public boolean authenticate(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }
}