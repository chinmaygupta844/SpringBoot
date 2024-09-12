package com.example.springNew.newSpringApp.config;

import com.example.springNew.newSpringApp.common.swimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.springNew.newSpringApp.common.Coach;
@Configuration
public class Sportconfig {

    @Bean
    public Coach swimCoach(){
        return new swimCoach();
    }
}
