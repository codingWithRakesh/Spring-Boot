package com.learnRESTAPIs.learnRESTAPIs.service;

import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getById(Long id);
    StudentDto getByIdUsingMapper(Long id);
    List<StudentDto> getAllStudentsUsingMapping();
//    StudentDto getByName(String name);
}
