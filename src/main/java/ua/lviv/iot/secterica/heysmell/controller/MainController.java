package ua.lviv.iot.secterica.heysmell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MainController {
    @GetMapping("/")
    public String getMain(){
//        return "Hello, it's my own API, I'm cool";
        return "yes, bitch!";
    }
    @GetMapping("/help")
    public String getHelp() {
        return "lol, help yourself by your own!\n Joking, it's just not implemented, sorry";
    }
}
