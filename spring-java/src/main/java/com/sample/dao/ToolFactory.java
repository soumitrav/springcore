package com.sample.dao;

import org.springframework.beans.factory.FactoryBean;

public class ToolFactory implements FactoryBean<Tool>{

	@Override
	public Tool getObject() throws Exception {
		return new Tool();
	}

	@Override
	public Class<?> getObjectType() {
		return Tool.class;
	}

}
