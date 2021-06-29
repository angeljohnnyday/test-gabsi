package com.exam.gradle.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exam.gradle.app.dto.ProductDTO;
import com.exam.gradle.app.entity.Product;
import com.exam.gradle.app.service.ProductServiceI;

public class ProductRestImpl implements ProductRestI {
	@Autowired private ProductServiceI productService;
	
	@Override
	public ResponseEntity<Object> get(String id) {
		try {
			Product product = productService.get(id);
			return new ResponseEntity<>(
				product, 
				product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND 
			);
		} catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> lst(){
		try {
			return new ResponseEntity<>(productService.lst(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<Object> create(ProductDTO productoDTO) {
		try {
			return new ResponseEntity<>(productService.create(productoDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> update(String id, ProductDTO productoDTO) {
		try {
			Product product = productService.update(id, productoDTO.getDescription());
			return new ResponseEntity<>(
				product, 
				product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND 
			);
		} catch (Exception e) {
			return new ResponseEntity<>(ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> delete(String id) {

		try {
			boolean result = productService.delete(id);
			return new ResponseEntity<>(
				result ? HttpStatus.OK : HttpStatus.NOT_FOUND 
			);
		} catch (Exception e) {
			return new ResponseEntity<>(ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
