package com.example.demo.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubjectRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void insertSubjectScore(Subject subject) {
        String sql = String.format("""
                INSERT IGNORE INTO %s (student_id, name, score)
                VALUES (:studentId, :name, :score)
                """, subject.getSubjectName());

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("studentId", subject.getStudentId())
                .addValue("name", subject.getStudentName())
                .addValue("score", subject.getScore());

        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

}

