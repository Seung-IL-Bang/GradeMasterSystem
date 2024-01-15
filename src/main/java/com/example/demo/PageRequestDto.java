package com.example.demo;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageRequestDto {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private short page = 1;

    @Builder.Default
    @Max(value = 5)
    @Min(value = 5)
    @Positive
    private short size = 5;

    public int getSkip() {
        return (page - 1) * size;
    }

    public Pageable getPageable(String... props) {
        return PageRequest.of(this.page - 1, this.size, Sort.by(props).descending());
    }



}
