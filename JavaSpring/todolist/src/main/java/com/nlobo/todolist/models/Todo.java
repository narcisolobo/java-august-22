package com.nlobo.todolist.models;

import java.util.Date;

public class Todo {
	
	private String description;
	private Date createdAt;
	
	public Todo() {}

	public Todo(String description) {
		super();
		this.description = description;
		this.createdAt = new Date();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

}
