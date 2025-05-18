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

    public boolean updateCar(int index, Car updatedCar) {
        if (index >= 0 && index < cars.size()) {
            Car existingCar = cars.get(index);
            if (updatedCar.getBrand() != null) existingCar.setBrand(updatedCar.getBrand());
            if (updatedCar.getHorsePower() != 0) existingCar.setHorsePower(updatedCar.getHorsePower());
            if (updatedCar.getFuelType() != null) existingCar.setFuelType(updatedCar.getFuelType());
            if (updatedCar.getYear() != 0) existingCar.setYear(updatedCar.getYear());
            if (updatedCar.getMileage() != 0) existingCar.setMileage(updatedCar.getMileage());
            if (updatedCar.getTransmission() != null) existingCar.setTransmission(updatedCar.getTransmission());
            if (updatedCar.getEngineVolume() != 0.0) existingCar.setEngineVolume(updatedCar.getEngineVolume());
            if (updatedCar.getColor() != null) existingCar.setColor(updatedCar.getColor());
            if (updatedCar.getPrice() != 0.0) existingCar.setPrice(updatedCar.getPrice());
            return true;
        }
        return false;
    }

    public boolean deleteCar(int index) {
        if (index >= 0 && index < cars.size()) {
            cars.remove(index);
            return true;
        }
        return false;
    }
}