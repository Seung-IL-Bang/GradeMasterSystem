package com.example.demo.subject;

import com.example.demo.student.Student;

import static java.lang.Math.*;

public class SubjectFactory {
    public static Subject createSubject(String subject, Student student) {
        return switch (subject.toLowerCase()) {
            case "korean" -> new Korean(student, student.getName(), (short) (random() * 101));
            case "english" -> new English(student, student.getName(), (short) (random() * 101));
            case "math" -> new Math(student, student.getName(), (short) (random() * 101));
            case "social" -> new Social(student, student.getName(), (short) (random() * 101));
            case "science" -> new Science(student, student.getName(), (short) (random() * 101));
            default -> throw new IllegalArgumentException("Unknown subject: " + subject);
        };

    }
}
