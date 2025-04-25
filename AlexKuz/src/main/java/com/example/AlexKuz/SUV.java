package com.example.AlexKuz;

public class SUV extends Car {
    public SUV() {
        super("Tesla Model X", 676, "Электрокар", 2022, 12022, "Автоматическая", 0.0);
        setColor("Черный");
        setPrice(8500000);
    }

    @Override
    public String getType() {
        return "Внедорожник";
    }
}