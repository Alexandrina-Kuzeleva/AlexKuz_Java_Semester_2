package com.example.AlexKuz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private Sedan sedan;

    @Autowired
    private SUV suv;

    @GetMapping("/showSedan")
    public String showSedan(Model model) {
        model.addAttribute("car", sedan);
        return "carDetails";
    }

    @GetMapping("/showSUV")
    public String showSUV(Model model) {
        model.addAttribute("car", suv);
        return "carDetails";
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