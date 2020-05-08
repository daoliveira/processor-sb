package com.example.demo.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends AbstractController<Product> {

	@Override
	@GetMapping("/product")
	ResponseEntity<Collection<Product>> getAll() {
		return super.getAll();
	}
	
	@Override
	@GetMapping("/product/{id}")
	ResponseEntity<Product> get(@PathVariable Long id) {
		return super.get(id);
	}
	
	@Override
	@PostMapping("/product")
	ResponseEntity<Product> post(@RequestBody Product product) {
		return super.post(product);
	}
	
	@Override
	@PutMapping("/product/{id}")
	ResponseEntity<Product> put(@PathVariable Long id, @RequestBody Product product) {
		return super.put(id, product);
	}
	
	@PatchMapping("/product/{id}")
	ResponseEntity<Product> patch(@PathVariable Long id, @RequestBody Product product) {
		return super.patch(id, product, Product.class);
	}
	
	@Override
	@DeleteMapping("/product/{id}")
	ResponseEntity<Product> delete(@PathVariable Long id) {
		return super.delete(id);
	}
}

class Product extends AbstractEntity {
	String name;
	String upc;
	String date;
	Boolean archived;
	
	public Product(Long id, String name, String upc, String date, Boolean archived) {
		super(id);
		this.name = name;
		this.upc = upc;
		this.date = date;
		this.archived = archived;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Boolean getArchived() {
		return archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
}