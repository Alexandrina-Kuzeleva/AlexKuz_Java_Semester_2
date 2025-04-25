package com.example.AlexKuz;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars;

    @PostConstruct
    public void init() {
        cars = new ArrayList<>();

        cars.add(new Sedan());
        cars.add(new SUV());
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getCarByIndex(int index) {
        if (index >= 0 && index < cars.size()) {
            return cars.get(index);
        }
        return null;
    }
}