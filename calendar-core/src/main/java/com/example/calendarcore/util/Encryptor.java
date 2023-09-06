package com.example.calendarcore.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
public interface Encryptor {
    String encrypt(String origin);
    boolean isMatch(String origin, String hashed);
}
