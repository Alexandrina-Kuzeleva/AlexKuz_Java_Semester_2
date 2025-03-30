package com.example.AlexKuz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.AlexKuz")
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Main.class);

        CarDisplayer displayer = context.getBean(CarDisplayer.class);
        Sedan sedan = context.getBean(Sedan.class);
        SUV suv = context.getBean(SUV.class);

        System.out.println("=== Displaying Cars ===");
        displayer.display(sedan);
        displayer.display(suv);

        context.close();
    }
}

