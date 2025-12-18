package com.learnRESTAPIs.learnRESTAPIs.service;

import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
}
