package br.com.thiagocavalieri.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// I would use @RestController, but I'm keeping that as knowledge base.
@Controller
@ResponseBody
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello() {
        return "HelloController";
    }
}
