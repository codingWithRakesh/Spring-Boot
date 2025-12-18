package com.learnRESTAPIs.learnRESTAPIs.controller;

import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;
import com.learnRESTAPIs.learnRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(4L,"Rakesh","rakesh@gmail.com");
    }
}
