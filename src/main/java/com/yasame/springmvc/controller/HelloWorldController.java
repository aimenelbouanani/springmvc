package com.yasame.springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloWorldController {
    //Handler method to hndle the request /hello-world request
    @GetMapping("/hello-world")
// http://localhost:8080/hello-world
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello-world";
    }
}
