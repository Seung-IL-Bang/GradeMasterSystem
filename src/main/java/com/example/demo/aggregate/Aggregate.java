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
    private int id;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private short korean;

    @Column(nullable = false)
    private short english;

    @Column(nullable = false)
    private short math;

    @Column(nullable = false)
    private short social;

    @Column(nullable = false)
    private short science;

    @Column(nullable = false)
    private int sum;

    @Column(nullable = false)
    private double avg;

    public int getSum() {
        return korean + english + math + social + science;
    }

    public double getAvg() { // TODO: 최적화
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

}
