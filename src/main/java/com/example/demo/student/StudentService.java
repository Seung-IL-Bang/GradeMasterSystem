package com.example.demo.student;

import com.example.demo.aggregate.AggregateRepository;
import com.example.demo.subject.SubjectFactory;
import com.example.demo.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;

    private final AggregateRepository aggregateRepository;

    @Transactional
    public void register(String name) {
        Student student = Student.builder()
                .name(name)
                .build();

        studentRepository.save(student);
    }

    public List<Student> examParticipants() {
        return studentRepository.findAll();
    }


    @Transactional
    public void recognizeOMRScore(String subjectName) {

        // TODO: subjectName 이 유효한지 검증

        List<Student> students = studentRepository.findAll(); // 시험 치른 명단(Student Table)에 존재하는 학생

        students.stream()
                .map(student -> SubjectFactory.createSubject(subjectName, student))
                .forEach(subjectRepository::insertSubjectScore);

        // TODO: aggregate table 집계



    }
}
