package com.nlobo.superheroes.models;

import java.io.Serializable;
import java.util.Date;

public class Hero implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String alias;
	private Date createdAt;
	
	public Hero() {}
	
	public Hero(String name, String alias) {
		super();
		this.name = name;
		this.alias = alias;
		this.createdAt = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

}
