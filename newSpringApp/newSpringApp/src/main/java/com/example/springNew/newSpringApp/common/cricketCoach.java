package com.example.springNew.newSpringApp.common;

import org.springframework.stereotype.Component;


@Component
public class cricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "practise fastbowling for 15 min now";
    }
}

