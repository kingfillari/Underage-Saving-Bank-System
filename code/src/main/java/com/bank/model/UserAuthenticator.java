package com.bank.model;

public class UserAuthenticator {
    public boolean authenticate(String username, String password) {
        // Implement your user authentication logic here
        // For demonstration, we will assume a simple check
        return "user".equals(username) && "password".equals(password); // Replace with actual logic
    }
}