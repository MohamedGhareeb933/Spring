package devops.devopsdemo.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloRestController {

    @Value("${dev.name}")
    private String name;

    @GetMapping("/")
    public String helloController() {
        return "hello user " + name ;
    }

    @GetMapping("/time")
    public String theTime() {
        return "" + LocalDateTime.now();
    }

}
