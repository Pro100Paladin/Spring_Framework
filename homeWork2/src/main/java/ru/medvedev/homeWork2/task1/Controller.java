package ru.medvedev.homeWork2.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Servise servise;

    @Autowired
    public Controller(Servise servise) {
        this.servise = servise;
    }

    @GetMapping
    public String hello() {
        return this.servise.getGreeting();
    }
}
