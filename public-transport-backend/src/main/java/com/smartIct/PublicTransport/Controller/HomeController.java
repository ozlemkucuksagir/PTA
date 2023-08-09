package com.smartIct.PublicTransport.Controller;

import com.fasterxml.jackson.databind.deser.Deserializers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/auth")
public class HomeController extends Deserializers.Base {

@GetMapping("/home")
    public String home(){
    return "Home";
}

    @GetMapping("/admin")
    public String admin(){
        return "Admin";
    }
}
