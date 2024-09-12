package com.example.springNew.newSpringApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springNew.newSpringApp.common.Coach;
@RestController
public class demoController {
   private Coach myCoach;

    @Autowired
    public demoController( @Qualifier("swimCoach") Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
