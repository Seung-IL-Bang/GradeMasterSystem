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
public class English implements Subject{

    @Id
    @OneToOne
    private Student student;

    private String name;

    private short score;

    @Override
    public String getSubjectName() {
        return "English";
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
