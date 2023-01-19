package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import user.model.UserEntity;
import user.service.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private UserServiceImpl userService;
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 회원 가입페이지 요청
    @GetMapping("save")
    public String saveForm() {
        return "user/save";
    }
    
    @PostMapping("save")
    public String save(@ModelAttribute UserEntity userEntity) {
        Long userId = userService.save(userEntity);
        return "user/login";
    }

    @GetMapping("login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute UserEntity userEntity, HttpSession session) {
        if(userService.login(userEntity)) {
            session.setAttribute("loginEmail", userEntity.getUserEmail());
            return "redirect:/user/";
        } else {
            return "user/login";
        }
    }
}
