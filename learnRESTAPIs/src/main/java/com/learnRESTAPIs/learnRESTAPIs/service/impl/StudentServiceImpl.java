package com.learnRESTAPIs.learnRESTAPIs.service.impl;

import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;
import com.learnRESTAPIs.learnRESTAPIs.dto.Teacher;
import com.learnRESTAPIs.learnRESTAPIs.entity.Student;
import com.learnRESTAPIs.learnRESTAPIs.repository.StudentRepository;
import com.learnRESTAPIs.learnRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private Teacher teacher;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
        return studentDtos;
    }

    @Override
    public StudentDto getById(Long id) {
        Student students = studentRepository.findById(id).get();
        StudentDto studentDto = new StudentDto();
        studentDto.setId(students.getId());
        studentDto.setEmail(students.getEmail());
        studentDto.setName(students.getName());
        return studentDto;
    }

    public StudentDto getByIdUsingMapper(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudentsUsingMapping() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students
                .stream()
                .map(student -> modelMapper.map(students, StudentDto.class))
                .toList();
        return studentDtos;
    }

//    @Override
//    public StudentDto getByName(String name) {
//        Student student = studentRepository.findByName
//    }
}
