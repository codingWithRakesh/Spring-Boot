package com.learnRESTAPIs.learnRESTAPIs.service.impl;

import com.learnRESTAPIs.learnRESTAPIs.dto.AddStudentRequestDto;
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
import java.util.Map;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private Teacher teacher;
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper){
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

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

    @Override
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
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
        return studentDtos;
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("id not exists");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentById(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found"));
        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudentById(Long id, Map<String, Object> updateValue) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found"));

        updateValue.forEach((field, value) -> {
            switch (field) {
                case "name" :
                    student.setName((String) value);
                    break;
                case "email" :
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("not match");
            }
        });

        Student newStudent = studentRepository.save(student);
        return modelMapper.map(newStudent, StudentDto.class);
    }

   @Override
   public StudentDto getByName(String name) {
       Student student = studentRepository.findByName
   }
}
