package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()  // h2-console 화면을 사용하기 위한 해당 옵션 disable
                .and()
                .authorizeRequests()  // URL 별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()  // 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())  // API 는 USER 권한을 가진 사람만 가능
                .anyRequest().authenticated()  // 나머지 URL 들은 인증된 사용자(로그인한 사용자)에게만 허용
                .and()
                .logout()  // 로그아웃 기능에 대한 여러 설정의 진입점
                .logoutSuccessUrl("/")  // 로그아웃 성공시 메인화면으로 이동
                .and()
                .oauth2Login()  // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint()  // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                .userService(customOAuth2UserService);  // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
    }
}