package com.jojoldu.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication  // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정, 이 위치부터 설정을 읽어나감
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);  // 내장 WAS 실행 -> 언제 어디서나 같은 환경에서 배포 가능
    }
}