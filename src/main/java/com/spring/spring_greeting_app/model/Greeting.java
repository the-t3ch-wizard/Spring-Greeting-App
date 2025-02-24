package com.spring.spring_greeting_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public Greeting(){
        this.message = "Hello World";
    }

    public Greeting(String message){
        this.message = message;
    }

}
