package com.example.AlexKuz;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
class CarDisplayer implements CarDisplay {
    private String displayFormat = "short";

    @PostConstruct
    public void initialize() {
        System.out.println("CarDisplayer initialized with format: " + displayFormat);
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("CarDisplayer cleaned up");
    }

    @Override
    public void display(Car car) {
        if ("short".equals(displayFormat)) {
            System.out.println("Краткий формат:");
            System.out.println("Марка: " + car.getBrand());
            System.out.println("Год выпуска: " + car.getYear());
        } else if ("detailed".equals(displayFormat)) {
            System.out.println("Детализированный формат:");
            System.out.println("Марка: " + car.getBrand());
            System.out.println("Тип: " + car.getType());
            System.out.println("Тип топлива: " + car.getFuelType());
            System.out.println("Пробег: " + car.getMileage() + " км");
            System.out.println("Цвет: " + car.getColor());
        } else {
            System.out.println("Полный формат:");
            System.out.println("Марка: " + car.getBrand());
            System.out.println("Мощность: " + car.getHorsePower() + " л.с.");
            System.out.println("Тип: " + car.getType());
            System.out.println("Тип топлива: " + car.getFuelType());
            System.out.println("Год выпуска: " + car.getYear());
            System.out.println("Пробег: " + car.getMileage() + " км");
            System.out.println("Коробка передач: " + car.getTransmission());
            System.out.println("Объем двигателя: " + car.getEngineVolume() + " л");
            System.out.println("Цвет: " + car.getColor());
            System.out.println("Цена: " + car.getPrice() + " руб.");
        }
        System.out.println("-------------------");
    }
}