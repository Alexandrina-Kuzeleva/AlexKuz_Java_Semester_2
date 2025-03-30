package com.example.AlexKuz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
class SUV extends Car {
    public SUV() {
        super("Tesla Model X", 676, "Электрокар", 2022, 12022, "Автоматическая", 0.0);
        setColor("Черный");
        setPrice(8500000);
    }

    @Override
    public String getType() {
        return "Внедорожник";
    }

    @PostConstruct
    public void initializeCar() {
        System.out.println("SUV initialized: " + getBrand());
    }

    @PreDestroy
    public void destroyCar() {
        System.out.println("SUV destroyed: " + getBrand());
    }
}