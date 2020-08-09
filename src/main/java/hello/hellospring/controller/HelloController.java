package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // url 매핑
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // 데이터
        return "hello"; // 템플릿 랜더링
    }
}

// 컨트롤러에서 return 값으로 문자를 반환하면 'viewResolver'가 화면을 찾아서 처리