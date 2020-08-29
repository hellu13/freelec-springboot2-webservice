package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {  // User 의 CRUD 를 책임질 UserRepository

    Optional<User> findByEmail(String email);
}
