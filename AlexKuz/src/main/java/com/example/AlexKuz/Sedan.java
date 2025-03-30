package com.example.AlexKuz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
class Sedan extends Car {
    public Sedan() {
        super("Mitsubishi Pajero Sport", 122, "Бензин", 2014, 122228, "Робот", 1.6);
        setColor("Коричневый");
        setPrice(1800000);
    }

    @Override
    public String getType() {
        return "Седан";
    }

    @PostConstruct
    public void initializeCar() {
        System.out.println("Sedan initialized: " + getBrand());
    }

    @PreDestroy
    public void destroyCar() {
        System.out.println("Sedan destroyed: " + getBrand());
    }
}