package com.example.calendarcore.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BCryptEncryptorTest {
    @Test
    void test(){
        final String origin = "password";
        final Encryptor encryptor = new BCryptEncryptor();
        final String hash = encryptor.encrypt(origin);

        assertTrue(encryptor.isMatch(origin, hash));

        final String origin2 = "password2";
        assertFalse(encryptor.isMatch(origin2, hash));
    }

}