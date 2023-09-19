package com.TP.TEST.controller;

import com.TP.TEST.entity.User;
import com.TP.TEST.services.CustomerUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class TestController {

    private final CustomerUserDetailsService customerUserDetailsService;



    @PostMapping("/public/add")
    public void saveUser(@RequestBody User user){
        customerUserDetailsService.createUser(user);
    }


///////-------------------------------------------------------
    @GetMapping("/public")
    public String getHello(){
        return "hello from public";
    }

    @GetMapping("/api/admin")
    public String admin(){
        return "hello from admin................";
    }

    @GetMapping("/api/user")
    public String user(){
        return "hello from user-------------------------------------";
    }
}
