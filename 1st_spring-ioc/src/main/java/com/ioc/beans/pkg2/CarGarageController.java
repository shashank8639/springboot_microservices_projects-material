package com.ioc.beans.pkg2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
class Engine {
	void start() {
		System.out.println("Engine started");
	}
}

@Component
//@Primary // It represents the highest priority among other classes
class SuperMaxEngine extends Engine{
	void start() {
		System.out.println("Engine started smooth transition high performance");
	}
}
@Component
class Car {  //Car has-A Engine
	
	//property or field
	private Engine engine; // null (default)
	
	//SetterInjection
	@Autowired
	@Qualifier(value = "superMaxEngine")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void startTheCar() {

		System.out.println("Keep the Key");
		engine.start();
	}
}
public class CarGarageController {

	public static void main(String[] args) {

		ApplicationContext context 
			= new AnnotationConfigApplicationContext(AppConfig2.class);
		
		Car c1 = context.getBean("car", Car.class);
		
		c1.startTheCar();
	}

}
