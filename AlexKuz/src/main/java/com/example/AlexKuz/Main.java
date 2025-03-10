package com.example.AlexKuz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CarDisplayer sedanDisplayer = context.getBean("sedanDisplayer", CarDisplayer.class);
        CarDisplayer sedan2Displayer = context.getBean("sedan2Displayer", CarDisplayer.class);
        CarDisplayer suvDisplayer = context.getBean("suvDisplayer", CarDisplayer.class);

        sedanDisplayer.display();
        sedan2Displayer.display();
        suvDisplayer.display();
    }
}