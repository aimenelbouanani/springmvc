package com.yasame.springmvc.controller;

import com.yasame.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/variable-expression")
    public String variableExpression(Model model) {
        User user = new User("Moha", "Moha@gmail.com", "ADMIN", "Male");
        model.addAttribute("user", user);
        return "variable-expression";
    }

    // Handler to handle Selection Expression request
    // url : http://localhost:8080/selection-expression
    @GetMapping("/selection-expression")
    public String selectionExpression(Model model) {
        User user = new User("Moha", "Moha@gmail.com", "ADMIN", "Male");
        model.addAttribute("user", user);
        return "selection-expression";
    }

    // Handler to handle Message Expression request
    // url : http://localhost:8080/message-expression
    @GetMapping("/message-expression")
    public String messageExpression() {
        return "message-expression";
    }

    // Handler to handle Link Expression request
    @GetMapping("/link-expression")
    public String linkExpression() {
        return "link-expression";
    }

    // Handler to handle Link Expression request with parameters
    // url: http://localhost:8080/link-expression-wp
    @GetMapping("/link-expression-wp")
    public String linkExpressionWP(Model model) {
        model.addAttribute("id1", 1);
        model.addAttribute("id2", 2);
        return "link-expression-wp";
    }

    // Handler to handle URL destination with parameters
    // url: http://localhost:8080/url-destination/{id1}/{id2}
    @GetMapping("/url-destination/{id1}/{id2}")
    public String urlDestinationWithParameters(@PathVariable int id1, @PathVariable int id2, Model model) {
        model.addAttribute("id1", id1);
        model.addAttribute("id2", id2);
        return "url-destination-with-parameters";
    }

    //Handler to handle fragmentExpression
    //url:http://localhost:8080/fragment-expression
    @GetMapping("fragment-expression")
    public String fragmentExpression() {
        return "fragment-expression";
    }

    //Handler to handle usersURL(each attribute)
    //url:http://localhost:8080/usersURL
    @GetMapping("/usersURL")
    public String usersHandler(Model model) {
        List<User> usersList = Arrays.asList(new User[]{
                new User("Moha", "Moha@gmail.com", "ADMIN", "Male"),
                new User("toto", "toto@gmail.com", "USER", "Femal"),
                new User("Mohammed", "Mohammed@gmail.com", "ADMIN", "Male"),
                new User("titi", "titi@gmail.com", "USER", "Femal")
        });
        model.addAttribute("users", usersList);
        return "usersTemplate";
    }

    //Handler to handle if-unless-URL
    //url:http://localhost:8080/if-unless-URL
    @GetMapping("/if-unless-URL")
    public String ifUnlessHandler(Model model) {
        List<User> usersList = Arrays.asList(
                new User("Moha", "moha@gmail.com", "ADMIN", "Male"),
                new User("toto", "toto@gmail.com", "ADMIN", "Femal"),
                new User("Mohammed", "mohammed@gmail.com", "USER", "Male"),
                new User("titi", "titi@gmail.com", "USER", "Femal")
        );
        model.addAttribute("users", usersList);

        return "if-unless-template";
    }
    //handler to handle switch-case-URL(each attribute)
    //url:http://localhost:8080/switch-case-URL
    @GetMapping("switch-case-URL")
    public String switchCaseHandler(Model model) {
        User user = new User("Moha","Moha@gmail.com","GUEST","Male");
        model.addAttribute("user", user);
        return "switch-case-template";
    }




}