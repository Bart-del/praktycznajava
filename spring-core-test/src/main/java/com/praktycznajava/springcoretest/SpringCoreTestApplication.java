package com.praktycznajava.springcoretest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreTestApplication {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("Spring-Bean.xml");
		Employee employee = (Employee) beanFactory.getBean("employee");
		System.out.println("employee Id : " + employee.getEmployeeId());
		System.out.println("employee Name : " + employee.getEmployeeName());
	}
}
