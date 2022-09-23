package com.mariia.habittracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HabitNameException extends RuntimeException {

    public HabitNameException(String message) {
        super(message);
    }
}
