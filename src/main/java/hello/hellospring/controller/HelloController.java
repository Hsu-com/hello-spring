package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // url 매핑
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // 데이터
        return "hello"; // 템플릿 랜더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody       // viewResolver를 사용하지 않음
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody   // 객체를 넘김 (json) -> HttpMessageConverter(JsonConverter) 동작
    public Hello helloApi(@RequestParam("name") String name){     // json으로 반환
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
// 컨트롤러에서 return 값으로 문자를 반환하면 'viewResolver'가 화면을 찾아서 처리

// HttpMessageConverter
//- 기본 문자처리 : StringHttpMessageConverter
//- 기본 객체처리 : MappingJackson2HttpMessageConverter (json 변환 라이브러리 : Jackson2, Gson)
// 실무에서는 기본형으로 자주 쓰임