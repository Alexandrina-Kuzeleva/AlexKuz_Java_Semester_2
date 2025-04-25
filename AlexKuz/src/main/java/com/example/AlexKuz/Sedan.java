package com.example.AlexKuz;

public class Sedan extends Car {
    public Sedan() {
        super("Mitsubishi Pajero Sport", 122, "Бензин", 2014, 122228, "Робот", 1.6);
        setColor("Коричневый");
        setPrice(1800000);
    }

    @Override
    public String getType() {
        return "Седан";
    }
}