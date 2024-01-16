package com.example.demo.subject;

import com.example.demo.student.Student;

import static java.lang.Math.*;

public class SubjectFactory {
    public static Subject createSubject(String subjectName, Student student) {

        return switch (SubjectType.fromEnum(subjectName)) {
            case KOREAN -> new Korean(student, student.getName(), (short) (random() * 101));
            case ENGLISH -> new English(student, student.getName(), (short) (random() * 101));
            case MATH -> new Math(student, student.getName(), (short) (random() * 101));
            case SOCIAL -> new Social(student, student.getName(), (short) (random() * 101));
            case SCIENCE -> new Science(student, student.getName(), (short) (random() * 101));
        };

    }
}
