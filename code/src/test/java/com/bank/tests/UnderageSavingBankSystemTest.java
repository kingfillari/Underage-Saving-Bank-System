package com.bank.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import java.util.Scanner;

import com.bank.model.Child;
import com.bank.model.Parent;
import com.bank.model.User;
import com.bank.model.UserAuthenticator;
import com.bank.UnderageSavingBankSystem;
import com.bank.model.Account;
import com.bank.model.AdminAuthenticator;

public class UnderageSavingBankSystemTest {

    private UnderageSavingBankSystem system;
    private UserAuthenticator userAuth;
    private AdminAuthenticator adminAuth;

    @BeforeEach
    public void setup() {
        system = new UnderageSavingBankSystem();
        userAuth = new UserAuthenticator();
        adminAuth = new AdminAuthenticator("admin", "admin123");
    }

    @Test
    public void testAddUser() {
        User user = new Parent("John Doe", "PARENT_ID");
        system.addUser(user);
        assertTrue(system.getUsers().contains(user));
    }

    // @Test
    // public void testCreateAccount() {
    // Child child = new Child("Jane Doe", "CHILD_ID", 10);
    // system.createAccount(child);
    // assertNotNull(system.getAccountForChild(child));
    // }

    // @Test
    // public void testListUsers() {
    // User user1 = new Parent("John Doe", "PARENT_ID");
    // User user2 = new Parent("Jane Doe", "PARENT_ID");
    // system.addUser(user1);
    // system.addUser(user2);
    // system.listUsers();
    // // Verify that the users are listed correctly
    // }

    // @Test
    // public void testUserRegistration() {
    // User user = new Parent("John Doe", "PARENT_ID");
    // system.addUser(user);
    // system.userRegistration(new Scanner(System.in), user);
    // // Verify that the child is added to the user
    // }

    // @Test
    // public void testMakeTransaction() {
    // Child child = new Child("Jane Doe", "CHILD_ID", 10);
    // system.createAccount(child);
    // system.makeTransaction(new Scanner(System.in), child);
    // // Verify that the transaction is successful
    // }

    // @Test
    // public void testGetAccountForChild() {
    // Child child = new Child("Jane Doe", "CHILD_ID", 10);
    // system.createAccount(child);
    // Account account = system.getAccountForChild(child);
    // assertNotNull(account);
    // }

    // @Test
    // public void testAdminLogin() {
    // String adminUsername = "admin";
    // String adminPassword = "admin123";
    // assertTrue(adminAuth.authenticate(adminUsername, adminPassword));
    // }

    @AfterEach
    public void tearDown() {
        // Delete the user data file
        File userDataFile = new File("users.txt");
        if (userDataFile.exists()) {
            userDataFile.delete();
        }
        // Delete the account data file
        File accountDataFile = new File("accounts.txt");
        if (accountDataFile.exists()) {
            accountDataFile.delete();
        }
    }
}