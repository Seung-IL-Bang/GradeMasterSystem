package com.example.demo.student;

import com.example.demo.aggregate.Aggregate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 10)
    private String name;

    public Aggregate myAggregate() {
        return Aggregate.builder()
                .student(this)
                .name(this.name)
                .build();
    }

}
