package com.spring.spring_greeting_app.repository;

import com.spring.spring_greeting_app.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {}
