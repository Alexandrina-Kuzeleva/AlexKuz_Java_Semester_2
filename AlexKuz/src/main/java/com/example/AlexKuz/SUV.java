package com.example.AlexKuz;

public class SUV extends Car {
    public SUV(String brand, int horsePower, String fuelType, int year,
               int mileage, String transmission, double engineVolume) {
        super(brand, horsePower, fuelType, year, mileage, transmission, engineVolume);
    }

    @Override
    public String getType() {
        return "Внедорожник";
    }
}