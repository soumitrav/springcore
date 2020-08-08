package com.sample;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sample.dao.CalanderFactory;
import com.sample.dao.Tool;
import com.sample.dao.ToolFactory;

@Configuration
@ComponentScan(basePackages = {"com.sample"})
public class AppConfig {

	
	@Bean("cale")
	public CalanderFactory calFactory () throws Exception {
		CalanderFactory factory = new CalanderFactory();
		factory.addDays(3);
		return factory;
	}
	
	@Bean
	public Calendar getCal() throws Exception {
		return calFactory().getObject();
	}
	
	@Bean("tool")
	public ToolFactory toolFactory() {
		ToolFactory factory = new ToolFactory();
		return factory;
	}
	
	
	
	@Bean
	public Tool getTool1() throws Exception {
		Tool object = toolFactory().getObject();
		object.setName("HATH");
		return object;
	}
	
	
	@Bean
	public Tool getTool() throws Exception {
		Tool object = toolFactory().getObject();
		object.setName("Hathoda");
		return object;
	}
	/*@Bean(name = "speakerService")
	public SpeakerService getSpearkerService() {
		SpearkerServiceImpl spearkerServiceImpl = new SpearkerServiceImpl();
		//spearkerServiceImpl.setSpeakerRepository(getSpeakerRepository());
		return spearkerServiceImpl;
	}
	
	@Bean(name = "speakerRepository")
	public SpeakerRepository getSpeakerRepository() {
		return new SpeakerRepositoryImpl();
	}
	*/
	
}
