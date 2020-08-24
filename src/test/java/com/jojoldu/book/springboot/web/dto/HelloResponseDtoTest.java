package com.jojoldu.book.springboot.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;  // assertj 는 assert 와 달리 추가적으로 라이브러리 필요X, 자동완성이 더 확실히 지원

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  // 검증하고 싶은 대상을 메소드 인자로 받는다, assertThat 에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

