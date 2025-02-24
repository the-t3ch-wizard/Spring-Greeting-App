package com.spring.spring_greeting_app.controller;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Greeting> getGreeting(@RequestParam(value = "firstName", required = false, defaultValue = "") String firstName,@RequestParam(value = "lastName", required = false, defaultValue = "") String lastName){
        return new ResponseEntity<>(greetingService.getCustomGreeting(firstName, lastName), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Greeting> postGreeting(@RequestBody Greeting greeting){
        return new ResponseEntity<>(greetingService.saveGreeting(greeting), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable String id){
        System.out.println("TEST : "+id);
        return new ResponseEntity<>(greetingService.getGreetingById(Long.parseLong(id)), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Greeting> deleteGreeting(){
        return new ResponseEntity<>(new Greeting("Greeting using delete method By Ayush"), HttpStatus.OK);
    }

}
