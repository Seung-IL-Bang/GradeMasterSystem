package com.example.demo;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorMessage {

    private int code;
    private HttpStatus status;
    private String message;

    public ErrorMessage(HttpStatus status, String message) {
        this.code = status.value();
        this.status = status;
        this.message = message;
    }

    public static ErrorMessage of(HttpStatus status, String message) {
        return new ErrorMessage(status, message);
    }
}
