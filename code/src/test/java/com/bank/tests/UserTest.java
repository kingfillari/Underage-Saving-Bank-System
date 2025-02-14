package com.bank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.bank.model.User;

class UserTest {
    @Test
    void testUserInitialization() {
        // Since User is abstract, we create an anonymous subclass for testing
        User user = new User("Abebe Bekele", "U001") {};

        assertEquals("Abebe Bekele", user.getName(), "User name should be set correctly.");
        assertEquals("U001", user.getUserId(), "User ID should be set correctly .");
    }
}

