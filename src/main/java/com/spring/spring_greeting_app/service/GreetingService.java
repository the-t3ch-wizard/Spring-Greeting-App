package com.spring.spring_greeting_app.service;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public static Greeting getCustomGreeting(String firstName, String lastName){
        if (firstName != null && firstName.length() > 0){
            if (lastName != null && lastName.length() > 0) return new Greeting("Hello "+firstName+" "+lastName);
            else return new Greeting("Hello "+firstName);
        }
        return new Greeting();
    }

}
