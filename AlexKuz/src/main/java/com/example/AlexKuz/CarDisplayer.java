package com.example.AlexKuz;

public class CarDisplayer {
    private Car car;

    public CarDisplayer(Car car) {
        this.car = car;
    }

    public void display() {
        System.out.println("Марка: " + car.getBrand());
        System.out.println("Мощность: " + car.getHorsePower() + " л.с.");
        System.out.println("Тип: " + car.getType());
        System.out.println("Тип топлива: " + car.getFuelType());
        System.out.println("Год выпуска: " + car.getYear());
        System.out.println("Пробег: " + car.getMileage() + " км");
        System.out.println("Коробка передач: " + car.getTransmission());
        System.out.println("Объем двигателя: " + car.getEngineVolume() + " л");
        System.out.println("-------------------");
    }
}