package com.learnRESTAPIs.learnRESTAPIs.service;

import com.learnRESTAPIs.learnRESTAPIs.dto.AddStudentRequestDto;
import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getById(Long id);
    StudentDto getByIdUsingMapper(Long id);
    List<StudentDto> getAllStudentsUsingMapping();

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteById(Long id);

    StudentDto updateStudentById(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudentById(Long id, Map<String, Object> updateValue);
//    StudentDto getByName(String name);
}
