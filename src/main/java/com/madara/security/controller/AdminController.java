package com.madara.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> adminHello(){
        return new ResponseEntity<>("Endpoint only admin can access", HttpStatus.OK);
    }
}
