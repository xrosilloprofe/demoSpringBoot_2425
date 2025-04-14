package es.ieslavereda.demospringboot_2425;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //esto es un EndPoint
    @GetMapping("/hello")
    public String sayHello(){
        return "HELLO (junior) Developer";
    }

}
