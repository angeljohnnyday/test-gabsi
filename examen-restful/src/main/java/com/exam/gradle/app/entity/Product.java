package com.exam.gradle.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column(name = "io.springfox:springfox-swagger-ui:${swagger_version}", length = 10)
	private String id;
	
	@Column(name = "name", length = 20)
	private String name;
	
	@Column(name = "description", length = 200)
	private String description;
	
	@Column(name = "price", scale = 2)
	private Double price;
	
	@Column(name = "model", length = 10)
	private String model;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
