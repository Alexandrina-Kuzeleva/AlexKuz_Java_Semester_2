package com.example.AlexKuz;

public class Sedan implements Car {
    private String brand;
    private int horsePower;
    private String fuelType;   
    private int year;
    private int mileage;
    private String transmission; 
    private double engineVolume;

    public Sedan(String brand, int horsePower, String fuelType, int year, 
                 int mileage, String transmission, double engineVolume) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
        this.year = year;
        this.mileage = mileage;
        this.transmission = transmission;
        this.engineVolume = engineVolume;
    }

    @Override
    public String getBrand() { return brand; }
    @Override
    public int getHorsePower() { return horsePower; }
    @Override
    public String getType() { return "Седан"; }
    @Override
    public String getFuelType() { return fuelType; }
    @Override
    public int getYear() { return year; }
    @Override
    public int getMileage() { return mileage; }
    @Override
    public String getTransmission() { return transmission; }
    @Override
    public double getEngineVolume() { return engineVolume; }
}