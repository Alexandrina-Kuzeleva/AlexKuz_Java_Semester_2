package com.example.AlexKuz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car sedan = context.getBean("sedan", Car.class);
        Car sedan2 = context.getBean("sedan2", Car.class);
        Car suv = context.getBean("suv", Car.class);
        CarDisplay sedanDisplayer = context.getBean("sedanDisplayer", CarDisplay.class);
        CarDisplay sedan2Displayer = context.getBean("sedan2Displayer", CarDisplay.class);
        CarDisplay suvDisplayer = context.getBean("suvDisplayer", CarDisplay.class);

        System.out.println("=== Displaying Cars ===");
        sedanDisplayer.display(sedan);
        sedan2Displayer.display(sedan2);
        suvDisplayer.display(suv);

        CarDisplay sedan2DisplayerAnother = context.getBean("sedan2Displayer", CarDisplay.class);
        System.out.println("Same sedan2Displayer? " + (sedan2Displayer == sedan2DisplayerAnother));

        ((ClassPathXmlApplicationContext) context).close();
    }
}