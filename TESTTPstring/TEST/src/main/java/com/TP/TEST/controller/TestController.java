package com.TP.TEST.controller;

import com.TP.TEST.entity.User;
import com.TP.TEST.services.CustomerUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {

    // read - write - delete - access - execute ====> authorities
    // ADMIN - USER - MANAGER -CLIENT -ADMINISTRATOR ====> roles
    // GrantedAuthority ======> something with a name ROLE_ADMIN  - ROLE_MANAGER - ROLE_USER

    /*
    *  @PreAuthorise
    *  @PostAuthorise
    *  @PreFilter
    *  @PostFilter
     */

///////-------------------------------------------------------
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('read')")
    public String test(){
        return "hello TEST";
    }

    @GetMapping("/demo")
    public String demo(){
        return "hello demo";
    }





}
