package com.example.Split_Wise_application.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClass {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
