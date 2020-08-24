package com.jojoldu.book.springboot.web.dto;
// lombok 은 자바 개발할 때 자주 사용하는 코드 Getter, Setter, 기본생성자, toString 등을 어노테이션으로 자동 생성
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter  // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor  // 선언된 모든 final 필드가 포함된 생성자를 생성, final 이 없는 생성자는 포함X

public class HelloResponseDto {
    private final String name;
    private final int amount;
}
