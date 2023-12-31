package com.example.calendarapi.dto;

import lombok.Getter;

@Getter
public class AuthUser {
    private final Long id;

    public AuthUser(Long id) {
        this.id = id;
    }
    public static AuthUser of(Long id){
        return new AuthUser(id);
    }
}
