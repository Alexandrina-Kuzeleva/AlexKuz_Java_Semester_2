package com.example.AlexKuz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @Autowired
    private Sedan sedan;

    @Autowired
    private SUV suv;

    @GetMapping("/showSedan")
    public String showSedan(Model model) {
        model.addAttribute("car", sedan);  // Передаем объект Sedan в модель
        return "carDetails";  // Шаблон Thymeleaf
    }

    @GetMapping("/showSUV")
    public String showSUV(Model model) {
        model.addAttribute("car", suv);  // Передаем объект SUV в модель
        return "carDetails";  // Шаблон Thymeleaf
    }
}
