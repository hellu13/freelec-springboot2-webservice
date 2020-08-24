package com.jojoldu.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{  // DB Layer 접근자, <Entity 클래스, PK 타입>

}
