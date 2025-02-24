package com.spring.spring_greeting_app.controller;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @GetMapping("")
    public ResponseEntity<Greeting> getGreeting(){
        return new ResponseEntity<>(GreetingService.getDefaultGreeting(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Greeting> postGreeting(){
        return new ResponseEntity<>(new Greeting("Greeting using post method By Ayush"), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Greeting> putGreeting(){
        return new ResponseEntity<>(new Greeting("Greeting using put method By Ayush"), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Greeting> deleteGreeting(){
        return new ResponseEntity<>(new Greeting("Greeting using delete method By Ayush"), HttpStatus.OK);
    }

}
