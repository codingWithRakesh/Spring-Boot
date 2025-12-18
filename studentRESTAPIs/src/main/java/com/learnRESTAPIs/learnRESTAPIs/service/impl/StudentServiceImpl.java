package com.learnRESTAPIs.learnRESTAPIs.service.impl;

import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;
import com.learnRESTAPIs.learnRESTAPIs.entity.Student;
import com.learnRESTAPIs.learnRESTAPIs.repository.StudentRepository;
import com.learnRESTAPIs.learnRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
        return studentDtos;
    }
}
