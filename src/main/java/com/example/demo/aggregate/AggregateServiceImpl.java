package com.example.demo.aggregate;

import com.example.demo.PageRequestDto;
import com.example.demo.PageResponseDto;
import com.example.demo.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AggregateServiceImpl implements AggregateService {

    private final AggregateRepository aggregateRepository;

    @Override
    public Aggregate getTestResult(int id) {

        return aggregateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 학생 Id는 존재하지 않습니다."));
    }

    @Override
    public PageResponseDto<Aggregate> getAllTestResult(PageRequestDto requestDto) {
        Page<Aggregate> pages = aggregateRepository.findAll(requestDto.getPageable("id"));

        return PageResponseDto.<Aggregate>builder()
                .dtoList(pages.getContent())
                .total(pages.getTotalElements())
                .build();
    }

    @Transactional
    @Override
    public void postStudent(RequestDto requestDto) {

        Aggregate aggregate = requestDto.toEntity();
        aggregate.setSum();
        aggregate.setAvg();

        aggregateRepository.save(aggregate);
    }

    @Transactional
    @Override
    public Aggregate putStudent(int id, RequestDto requestDto) {

        Aggregate aggregate = aggregateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 학생 Id는 존재하지 않습니다."));

        aggregate.change(requestDto);

        return aggregateRepository.save(aggregate);
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {

        Aggregate aggregate = aggregateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 학생 Id는 존재하지 않습니다."));

        aggregateRepository.delete(aggregate);
    }


}
