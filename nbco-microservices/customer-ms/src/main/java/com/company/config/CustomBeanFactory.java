package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;;

@Configuration
public class CustomBeanFactory {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
