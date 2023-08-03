package hello.hellospring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("test")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "test";
    }

    @GetMapping("hello-templates")
    public String hello_templates(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templates";
    }

}
