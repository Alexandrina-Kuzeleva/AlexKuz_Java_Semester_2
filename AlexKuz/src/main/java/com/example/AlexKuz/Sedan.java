package com.example.AlexKuz;

public class Sedan extends Car {
    public Sedan(String brand, int horsePower, String fuelType, int year,
                 int mileage, String transmission, double engineVolume) {
        super(brand, horsePower, fuelType, year, mileage, transmission, engineVolume);
    }

    @Override
    public String getType() {
        return "Седан";
    }
}