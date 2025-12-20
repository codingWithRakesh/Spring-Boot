package com.learnRESTAPIs.learnRESTAPIs.controller;

import com.learnRESTAPIs.learnRESTAPIs.dto.AddStudentRequestDto;
import com.learnRESTAPIs.learnRESTAPIs.dto.StudentDto;
import com.learnRESTAPIs.learnRESTAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getById(id));
    }

    @GetMapping("/studentsUsingMapper")
    public List<StudentDto> getStudentUsingMapper(){
        return studentService.getAllStudentsUsingMapping();
    }

    @GetMapping("/studentUsingMapper/{id}")
    public StudentDto getStudentUsingMapperById(@PathVariable Long id){
        return studentService.getByIdUsingMapper(id);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> editStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentById(id,addStudentRequestDto));
    }

    @PatchMapping("/updatePartial/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updateValue){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updatePartialStudentById(id, updateValue));
    }

//    @GetMapping("/student/{name}")
//    public StudentDto getStudentByName(@PathVariable String name){
//        return studentService.getByName(name);
//    }
}
