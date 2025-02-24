package com.spring.spring_greeting_app.service;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    public Greeting getCustomGreeting(String firstName, String lastName){
        if (firstName != null && !firstName.isEmpty()){
            if (lastName != null && !lastName.isEmpty()) return new Greeting("Hello "+firstName+" "+lastName);
            else return new Greeting("Hello "+firstName);
        }
        return new Greeting();
    }

    public Greeting saveGreeting(Greeting greeting) {
        greetingRepository.save(greeting);
        return greeting;
    }

    public Greeting getGreetingById(Long id) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) return existingGreeting.get();
        return new Greeting();
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, Greeting newGreeting){
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newGreeting.getMessage());
            return greetingRepository.save(greeting);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }
}
