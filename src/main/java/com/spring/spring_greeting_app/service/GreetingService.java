package com.spring.spring_greeting_app.service;

import com.spring.spring_greeting_app.model.Greeting;
import com.spring.spring_greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public static Greeting getDefaultGreeting(){
        return new Greeting();
    }

}
