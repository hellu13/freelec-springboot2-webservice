package com.jojoldu.book.springboot.web;
import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {  // 페이지에 관련된 컨트롤러

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")  // url 매핑
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());  // index.mustache 에서 posts 란 이름으로 사용
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");  // CustomOAuth2UserService 에서 로그인 성공 시 세션에 SessionUser 를 저장하도록 구성
        if(user != null ) {
            model.addAttribute("userName", user.getName());
        }
        return "index";  // index.mustache 와 매핑
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }  // posts-save.mustache 와 매핑

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";  // posts-update.mustache 와 매핑
    }
}
