package com.ioc.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component //registers this class as bean with config file
class Car {
	
	public void startTheCar() {

		System.out.println("car is started");
	}
	public void stopc() {

		System.out.println("Car is stopped");
	}
}

@Component
class FoodItem {
	
	public void eatTheBest() {

		System.out.println("The best food is ur favourite and eating at right time");
	}
}

public class DemoController {

	public static void main(String[] args) {
	
		//IOC container
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfiguration.class);

		Car c1 = context.getBean("car", Car.class);

		System.out.println(c1);
		c1.startTheCar();
		c1.stopc();
		
		FoodItem foodItem = context.getBean("foodItem", FoodItem.class);
		System.out.println(foodItem);
	}
}
