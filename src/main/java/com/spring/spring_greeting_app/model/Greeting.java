package com.spring.spring_greeting_app.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Greeting {

    private String message;

    public Greeting(String message){
        this.message = message;
    }

}
