package pl.praktycznajava.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String helloWord(){
        return "Hello world";
    }
}

