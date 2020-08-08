package com.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.SpeakerService;

public class MainApp {

	public static void main(String [] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		//ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpeakerService bean = app.getBean("speakerService",SpeakerService.class);
		System.out.println(bean.getAllSpearker().get(0).getFirstName());
	}
}
