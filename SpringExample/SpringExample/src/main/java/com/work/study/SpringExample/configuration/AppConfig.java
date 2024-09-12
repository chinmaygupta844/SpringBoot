package com.work.study.SpringExample.configuration;

import com.work.study.SpringExample.DB;
import com.work.study.SpringExample.PordDB;
import com.work.study.SpringExample.devDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name ="project.mode", havingValue = "production")
    public DB getpordBean(){
        return new PordDB();
    }
    @Bean
    @ConditionalOnProperty(name ="project.mode", havingValue = "development")
    public DB getdevBean(){
        return new devDB();
    }

    @Bean
    public ModelMapper modelMapper(){
       return  new ModelMapper();
    }
}
