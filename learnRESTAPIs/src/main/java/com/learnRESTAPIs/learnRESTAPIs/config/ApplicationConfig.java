package com.learnRESTAPIs.learnRESTAPIs.config;

import com.learnRESTAPIs.learnRESTAPIs.dto.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Teacher getTeacherBean(){
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("Rakesh");
        return teacher;
    }
}
