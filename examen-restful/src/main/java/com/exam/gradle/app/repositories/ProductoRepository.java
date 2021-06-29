package com.exam.gradle.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.gradle.app.entity.Product;

@Repository
public interface ProductoRepository extends CrudRepository<Product, String> {}