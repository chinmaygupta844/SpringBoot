package com.example.springNew.newSpringApp.common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practise your back hand tennis";
    }
}
