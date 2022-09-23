package com.mariia.habittracker.exceptions;

public class HabitNameExceptionResponse {

    private String habitName;

    public HabitNameExceptionResponse(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }
}
