package com.example.demo.aggregate;

import com.example.demo.PageRequestDto;
import com.example.demo.PageResponseDto;
import com.example.demo.RequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AggregateController {

    private final AggregateService aggregateService;

    @GetMapping("/student/{id}")
    public ResponseEntity<Aggregate> getStudent(@PathVariable("id") @Positive int id) {

        Aggregate aggregate = aggregateService.getTestResult(id);

        return new ResponseEntity<>(aggregate, HttpStatus.OK);
    }

    @GetMapping("/student/list")
    public ResponseEntity<PageResponseDto<Aggregate>> getStudentList(@Valid PageRequestDto requestDto,
                                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            requestDto = PageRequestDto.builder().build();
        }

        PageResponseDto<Aggregate> response = aggregateService.getAllTestResult(requestDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<String> postStudent(@Valid @RequestBody RequestDto requestDto) {

        aggregateService.postStudent(requestDto);

        return new ResponseEntity<>("created student", HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Aggregate> putStudent(@Valid @RequestBody RequestDto requestDto,
                                                @PathVariable("id") @Positive int id) {
        Aggregate response = aggregateService.putStudent(id, requestDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") @Positive int id) {

        aggregateService.deleteStudent(id);

        return new ResponseEntity<>("deleted student", HttpStatus.OK);
    }


}
