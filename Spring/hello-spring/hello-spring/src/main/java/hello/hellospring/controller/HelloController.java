package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
;
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")    // mvc, 템플릿 엔진 방식
    public String helloMvc(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody   // 객체가 오면 json을 반환하는 방식
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 객체
        hello.setName(name);
        return hello;
    } // api방식
    // HttpMessageConverter 를 통해 json 또는 string 으로 convert
    static class Hello{
        private String name;
        // 프로퍼티 접근 방식
        public String getName() {
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

}
