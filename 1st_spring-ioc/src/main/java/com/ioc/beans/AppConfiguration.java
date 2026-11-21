package com.ioc.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Configuration file to provide information of Bean classes to IOC container
@Configuration //To represent this class as Configuration file
@ComponentScan(basePackages = "com.ioc.beans")
public class AppConfiguration {

}
