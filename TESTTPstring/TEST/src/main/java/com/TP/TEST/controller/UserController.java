package com.TP.TEST.controller;


import com.TP.TEST.entity.User;
import com.TP.TEST.services.CustomerUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final CustomerUserDetailsService customerUserDetailsService;
    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        customerUserDetailsService.createUser(user);
    }


    ///////-------------------------------------------------------
    @GetMapping("/admin")
    public String admin(){
        return "hello from admin................";
    }

    @GetMapping("/user")
    public String user(){
        return "hello from user-------------------------------------";
    }

}
