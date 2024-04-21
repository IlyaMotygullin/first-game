package com.example.project_swing_jdbc.config;

import com.example.project_swing_jdbc.aspects.RegisterWindowAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.example.project_swing_jdbc")
@EnableAspectJAutoProxy
public class MyConfig {
    @Bean
    public RegisterWindowAspect registerWindowAspect() {
        return new RegisterWindowAspect();
    }
}
