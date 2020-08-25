package com.jojoldu.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
// Posts 클래스로 Database 를 접근하게 해 줄 JpaRepository

public interface PostsRepository extends JpaRepository<Posts, Long>{  // DB Layer 접근자, <Entity 클래스, PK 타입>, CRUD 메소드가 자동으로 생성

}
