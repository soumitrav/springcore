package com.sample.dao;

public class Tool {

	int toolId;
	String name;
	public Tool(int toolId, String name) {
		super();
		this.toolId = toolId;
		this.name = name;
	}
	public Tool() {
		super();
	}
	public int getToolId() {
		return toolId;
	}
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
