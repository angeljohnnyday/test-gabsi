package com.exam.gradle.app.service;

import java.util.List;

import com.exam.gradle.app.dto.ProductDTO;
import com.exam.gradle.app.entity.Product;

public interface ProductServiceI {
	public Product get(String id);
	public List<Product> lst();
	public Product create(ProductDTO productDTO);
	public Product update(String id, String description);
	public boolean delete(String id);
}
