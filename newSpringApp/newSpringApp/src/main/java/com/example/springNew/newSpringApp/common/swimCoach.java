package com.example.springNew.newSpringApp.common;

public class swimCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "swim 100 m in the pool";
    }
}
