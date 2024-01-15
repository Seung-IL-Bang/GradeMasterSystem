package com.example.demo.aggregate;

import com.example.demo.RequestDto;
import com.example.demo.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne
    private Student student;

    @Column(length = 10, nullable = false)
    private String name;

    private short korean;

    private short english;

    private short math;

    private short social;

    private short science;

    private int sum;

    private double avg;

    private boolean state = false; // TODO: Map<Subject, boolean>

    public int getSum() {
        return korean + english + math + social + science;
    }

    public double getAvg() {
        return Math.round((getSum() / 5.0) * 100) / 100.0;
    }

    public void setSum() {
        this.sum = getSum();
    }

    public void setAvg() {
        this.avg = getAvg();
    }

    public void change(RequestDto requestDto) {
        this.korean = requestDto.getKorean();
        this.english = requestDto.getEnglish();
        this.math = requestDto.getMath();
        this.social = requestDto.getSocial();
        this.science = requestDto.getScience();
        this.sum = getSum();
        this.avg = getAvg();
    }

    // TODO
    public void isAllScoresEntered() {

    }

}
