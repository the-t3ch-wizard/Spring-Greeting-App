package com.spring.spring_greeting_app.service;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
