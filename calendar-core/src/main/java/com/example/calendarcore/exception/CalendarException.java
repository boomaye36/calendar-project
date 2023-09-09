package com.example.calendarcore.exception;

import lombok.Getter;

@Getter
public class CalendarException extends RuntimeException {
    private final ErrorCode errorCode;

    public CalendarException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }
}
