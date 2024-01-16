package com.example.demo.subject;

public enum SubjectType {

    KOREAN("korean"),
    ENGLISH("english"),
    MATH("math"),
    SOCIAL("social"),
    SCIENCE("science");

    final String type;

    SubjectType(String type) {
        this.type = type;
    }

    public static SubjectType fromEnum(String value) {
        return switch (value.toUpperCase()) {
            case "KOREAN" -> KOREAN;
            case "ENGLISH" -> ENGLISH;
            case "MATH" -> MATH;
            case "SOCIAL" -> SOCIAL;
            case "SCIENCE" -> SCIENCE;
            default -> throw new IllegalArgumentException("Invalid SubjectType: " + value);
        };
    }
}
