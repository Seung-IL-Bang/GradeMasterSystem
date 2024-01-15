package com.example.demo.subject;

import com.example.demo.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
public class Korean implements Subject{

    @Id
    @OneToOne
    private Student student;

    private String name;

    private short score;

    @Override
    public String getSubjectName() {
        return "Korean";
    }

    @Override
    public String getStudentId() {
        return student.getId();
    }

    @Override
    public String getStudentName() {
        return this.name;
    }
}
