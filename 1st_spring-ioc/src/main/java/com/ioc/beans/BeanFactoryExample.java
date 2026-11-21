package com.ioc.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryExample {

	public static void main(String[] args) {

		//IOC container Object
		DefaultListableBeanFactory factory = 
				new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader reader = 
				new XmlBeanDefinitionReader(factory);
		
		reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		String msg = (String) factory.getBean("message");
		System.out.println(msg);
	}

}
