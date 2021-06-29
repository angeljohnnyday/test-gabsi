package com.exam.gradle.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.gradle.app.dto.ProductDTO;
import com.exam.gradle.app.entity.Product;
import com.exam.gradle.app.repositories.ProductoRepository;
import com.exam.gradle.app.util.SecureRandom;

@Service
public class ProductServiceImpl implements ProductServiceI {
	@Autowired ProductoRepository productoRepository;
	
	public Product get(String id) {
		Optional<Product> product = productoRepository.findById(id);
		return product.get();
	}

	@Override
	public List<Product> lst() {
		return (List<Product>) productoRepository.findAll();
	}

	@Override
	public Product create(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(SecureRandom.get());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setModel(productDTO.getModel());
		productoRepository.save(product);
		
		return product;
	}

	@Override
	public Product update(String id, String description) {
		if(productoRepository.existsById(id)) {
			Product product = productoRepository.findById(id).get();
			product.setDescription(description);
			productoRepository.save(product);
			return product;
		}
		
		return null;
	}

	@Override
	public boolean delete(String id) {
		if(productoRepository.existsById(id)) {
			productoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
