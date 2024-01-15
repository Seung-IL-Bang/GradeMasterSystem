package com.example.demo;


import com.example.demo.aggregate.Aggregate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

    @NotBlank
    private String name;

    @Min(value = 0, message = "0 이상의 숫자만 가능합니다.")
    @Max(value = 100, message = "100 이하의 숫자만 가능합니다.")
    private short korean;

    @Min(value = 0, message = "0 이상의 숫자만 가능합니다.")
    @Max(value = 100, message = "100 이하의 숫자만 가능합니다.")
    private short english;

    @Min(value = 0, message = "0 이상의 숫자만 가능합니다.")
    @Max(value = 100, message = "100 이하의 숫자만 가능합니다.")
    private short math;

    @Min(value = 0, message = "0 이상의 숫자만 가능합니다.")
    @Max(value = 100, message = "100 이하의 숫자만 가능합니다.")
    private short social;

    @Min(value = 0, message = "0 이상의 숫자만 가능합니다.")
    @Max(value = 100, message = "100 이하의 숫자만 가능합니다.")
//    @Digits(integer = 3, fraction = 0, message = "정수값만 입력 가능합니다.") // 실수값이 short(정수) 타입으로 다운캐스팅 되므로 예외가 발생하지 않는다.
    private short science;


    public Aggregate toEntity() {
        return Aggregate.builder()
                .name(this.getName())
                .korean(this.getKorean())
                .english(this.getEnglish())
                .math(this.getMath())
                .social(this.getSocial())
                .science(this.getScience())
                .build();
    }
}
