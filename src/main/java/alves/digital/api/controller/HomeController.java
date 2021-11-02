package alves.digital.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {


    private String homeMessage(){
        return "API - Nura [in construction]\n " +
                "CSF - S2\n " +
                "Developed by Willyan\n" +
                "Using: Spring Boot, Lombok, H2, Actuator, JPA";
    }

}
