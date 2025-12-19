package com.learnRESTAPIs.learnRESTAPIs.controller;

import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;
import com.learnRESTAPIs.learnRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @GetMapping("/studentsUsingMapper")
    public List<StudentDto> getStudentUsingMapper(){
        return studentService.getAllStudentsUsingMapping();
    }

    @GetMapping("/studentUsingMapper/{id}")
    public StudentDto getStudentUsingMapperById(@PathVariable Long id){
        return studentService.getByIdUsingMapper(id);
    }

//    @GetMapping("/student/{name}")
//    public StudentDto getStudentByName(@PathVariable String name){
//        return studentService.getByName(name);
//    }
}
