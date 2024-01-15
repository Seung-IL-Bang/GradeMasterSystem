package com.example.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student/exam")
    public ResponseEntity<String> createStudent(@RequestParam(value = "name") String name) { // TODO: @Valid

        studentService.register(name);

        return new ResponseEntity<>("created student", HttpStatus.CREATED);
    }

    @GetMapping("/student/exam/list")
    public ResponseEntity<List<Student>> readStudents() {

        List<Student> participants = studentService.examParticipants();

        return new ResponseEntity<>(participants, HttpStatus.OK);
    }

    @PostMapping("/omr/process")
    public ResponseEntity<String> processGrading(@RequestParam(value = "subject") String subject) { // TODO: @Valid

        studentService.recognizeOMRScore(subject);

        return new ResponseEntity<>("process completed!", HttpStatus.OK);
    }
}
