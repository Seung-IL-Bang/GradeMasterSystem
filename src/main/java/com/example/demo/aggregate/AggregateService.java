package com.example.demo.aggregate;

import com.example.demo.PageRequestDto;
import com.example.demo.PageResponseDto;
import com.example.demo.RequestDto;
import com.example.demo.aggregate.Aggregate;

public interface AggregateService {

    Aggregate getTestResult(int id);

    PageResponseDto<Aggregate> getAllTestResult(PageRequestDto requestDto);

    void postStudent(RequestDto requestDto);

    Aggregate putStudent(int id, RequestDto requestDto);

    void deleteStudent(int id);
}
