package com.jojoldu.book.springboot.domain.posts;
import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter  // lombok 어노테이션, 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor  // lombok 어노테이션, 기본 생성자 자동 추가
@Entity  // JPA 어노테이션, 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {  // 실제 DB 의 테이블과 매칭될 클래스( Entity 클래스 )
    @Id  // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // PK의 생성 규칙을 나타냄, 옵션 = auto_increment
    private Long id;

    @Column(length = 500, nullable = false)  // 테이블의 컬럼을 나타냄, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용, 기본값 = VARCHAR(255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder  // 빌더 패턴 클래스 생성, 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
