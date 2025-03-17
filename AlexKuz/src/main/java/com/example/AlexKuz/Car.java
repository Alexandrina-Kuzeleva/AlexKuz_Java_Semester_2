package com.example.AlexKuz;

public abstract class Car {
    private String brand;
    private int horsePower;
    private String fuelType;
    private int year;
    private int mileage;
    private String transmission;
    private double engineVolume;
    private String color;
    private double price;

    protected Car(String brand, int horsePower, String fuelType, int year,
                  int mileage, String transmission, double engineVolume) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
        this.year = year;
        this.mileage = mileage;
        this.transmission = transmission;
        this.engineVolume = engineVolume;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getHorsePower() { return horsePower; }
    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }

    public double getEngineVolume() { return engineVolume; }
    public void setEngineVolume(double engineVolume) { this.engineVolume = engineVolume; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Абстрактный метод для типа машины
    public abstract String getType();

    public void initializeCar() {
        System.out.println("Car initialized: " + brand);
    }

    public void destroyCar() {
        System.out.println("Car destroyed: " + brand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", horsePower=" + horsePower +
                ", fuelType='" + fuelType + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", transmission='" + transmission + '\'' +
                ", engineVolume=" + engineVolume +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}