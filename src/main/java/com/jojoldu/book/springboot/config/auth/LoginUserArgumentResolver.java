package com.jojoldu.book.springboot.config.auth;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
// HandlerMethodArgumentResolver -> 조건에 맞는 경우 메소드가 있다면 HandlerMethodArgumentResolver 의 구현체가 지정한 값으로 해당 메소드의 파라미터를 넘길 수 있음
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    // 컨트롤러 메서드의 특정 파라미터를 지원하는지 판단
    public boolean supportsParameter(MethodParameter parameter) {

        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;  // 파라미터에 @Login 어노테이션이 있는지
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());  // 파라미터 클래스 타입이 SessionUser.class 인지

        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    // 파라미터에 전달할 객체를 생성. 여기서는 세션에서 객체를 가져온다
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws  Exception {
        return httpSession.getAttribute("user");
    }
}
