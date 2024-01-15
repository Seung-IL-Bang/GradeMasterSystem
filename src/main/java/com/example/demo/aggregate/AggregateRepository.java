package com.example.demo.aggregate;

import com.example.demo.aggregate.Aggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregateRepository extends JpaRepository<Aggregate, Integer> {
}
