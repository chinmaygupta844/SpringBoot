package com.example.springNew.newSpringApp.common;

import org.springframework.stereotype.Component;

@Component
public class baseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practise baseball for 20 min";
    }
}
