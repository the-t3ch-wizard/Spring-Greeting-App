package com.spring.spring_greeting_app.controller;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Greeting> addGreeting(@RequestBody Greeting greeting){
        return new ResponseEntity<>(greetingService.saveGreeting(greeting), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable String id){
        return new ResponseEntity<>(greetingService.getGreetingById(Long.parseLong(id)), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings(){
        return new ResponseEntity<>(greetingService.getAllGreetings(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable String id, @RequestBody Greeting newGreeting){
        return new ResponseEntity<>(greetingService.updateGreeting(Long.parseLong(id), newGreeting), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("")
    public ResponseEntity<Greeting> deleteGreeting(){
        return new ResponseEntity<>(new Greeting("Greeting using delete method By Ayush"), HttpStatus.OK);
    }

}
