package com.learnRESTAPIs.learnRESTAPIs;

import com.learnRESTAPIs.learnRESTAPIs.entity.Student;
import com.learnRESTAPIs.learnRESTAPIs.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void checkName(){
        List<Student> students = studentRepository.findByName("tarapada");
        for (Student student: students){
            System.out.println(student);
        }
    }
}
