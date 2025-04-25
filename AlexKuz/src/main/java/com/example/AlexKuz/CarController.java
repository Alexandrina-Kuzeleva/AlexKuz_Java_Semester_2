package com.example.AlexKuz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "carList";
    }

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

    @GetMapping("/addCar")
    public String showAddCarForm(Model model) {
        model.addAttribute("carForm", new CarForm());
        return "addCar";
    }

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