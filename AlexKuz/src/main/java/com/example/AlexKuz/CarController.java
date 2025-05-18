package com.example.AlexKuz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    // Отображение списка всех автомобилей
    @GetMapping("/cars")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "carList";
    }

    // Отображение деталей автомобиля по индексу
    @GetMapping("/showCar")
    public String showCar(@RequestParam("index") int index, Model model) {
        Car car = carService.getCarByIndex(index);
        if (car == null) {
            model.addAttribute("error", "Автомобиль не найден!");
            return "carDetails";
        }
        model.addAttribute("car", car);
        return "carDetails";
    }

    // Отображение формы для добавления автомобиля
    @GetMapping("/addCar")
    public String showAddCarForm(Model model) {
        model.addAttribute("carForm", new CarForm());
        return "addCar";
    }

    // Обработка отправки формы добавления автомобиля
    @PostMapping("/addCar")
    public String addCar(@ModelAttribute("carForm") CarForm carForm, Model model) {
        try {
            Car car;
            if ("Sedan".equals(carForm.getType())) {
                car = new Sedan();
            } else {
                car = new SUV();
            }
            car.setBrand(carForm.getBrand());
            car.setHorsePower(carForm.getHorsePower());
            car.setFuelType(carForm.getFuelType());
            car.setYear(carForm.getYear());
            car.setMileage(carForm.getMileage());
            car.setTransmission(carForm.getTransmission());
            car.setEngineVolume(carForm.getEngineVolume());
            car.setColor(carForm.getColor());
            car.setPrice(carForm.getPrice());

            carService.addCar(car);
            return "redirect:/cars";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при добавлении автомобиля: " + e.getMessage());
            return "addCar";
        }
    }

    // Отображение формы для редактирования автомобиля
    @GetMapping("/editCar")
    public String showEditCarForm(@RequestParam("index") int index, Model model) {
        Car car = carService.getCarByIndex(index);
        if (car == null) {
            model.addAttribute("error", "Автомобиль не найден!");
            return "editCar";
        }
        CarForm carForm = new CarForm();
        carForm.setType(car.getType());
        carForm.setBrand(car.getBrand());
        carForm.setHorsePower(car.getHorsePower());
        carForm.setFuelType(car.getFuelType());
        carForm.setYear(car.getYear());
        carForm.setMileage(car.getMileage());
        carForm.setTransmission(car.getTransmission());
        carForm.setEngineVolume(car.getEngineVolume());
        carForm.setColor(car.getColor());
        carForm.setPrice(car.getPrice());
        model.addAttribute("carForm", carForm);
        model.addAttribute("index", index);
        return "editCar";
    }

    // Обработка обновления автомобиля (PATCH)
    @PatchMapping("/cars/{index}")
    public String updateCar(@PathVariable("index") int index, @ModelAttribute("carForm") CarForm carForm, Model model) {
        try {
            Car updatedCar = new Car(carForm.getBrand(), carForm.getHorsePower(), carForm.getFuelType(),
                    carForm.getYear(), carForm.getMileage(), carForm.getTransmission(), carForm.getEngineVolume()) {
                @Override
                public String getType() {
                    return carForm.getType();
                }
            };
            updatedCar.setColor(carForm.getColor());
            updatedCar.setPrice(carForm.getPrice());

            boolean updated = carService.updateCar(index, updatedCar);
            if (!updated) {
                model.addAttribute("error", "Автомобиль не найден!");
                return "editCar";
            }
            return "redirect:/cars";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при обновлении автомобиля: " + e.getMessage());
            return "editCar";
        }
    }

    // Обработка удаления автомобиля (DELETE)
    @DeleteMapping("/cars/{index}")
    public String deleteCar(@PathVariable("index") int index) {
        carService.deleteCar(index);
        return "redirect:/cars";
    }

    // Метод из Лабы 7 для арифметических операций
    @GetMapping("/calculate")
    public String calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model) {
        double result;
        String errorMessage = null;

        try {
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        errorMessage = "Ошибка: Деление на ноль!";
                        model.addAttribute("error", errorMessage);
                        return "calculationResult";
                    }
                    result = num1 / num2;
                    break;
                default:
                    errorMessage = "Ошибка: Неверная операция! Используйте +, -, * или /";
                    model.addAttribute("error", errorMessage);
                    return "calculationResult";
            }
        } catch (Exception e) {
            errorMessage = "Ошибка: Неверные входные данные!";
            model.addAttribute("error", errorMessage);
            return "calculationResult";
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);
        return "calculationResult";
    }
}