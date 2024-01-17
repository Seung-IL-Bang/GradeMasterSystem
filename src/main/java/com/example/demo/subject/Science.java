package com.example.demo.subject;

import com.example.demo.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Entity
public class Science implements Subject {

    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private short score;

    @Override
    public String getSubjectName() {
        return SubjectType.SCIENCE.type;
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
