package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	@Transactional
	public List<String> sortThings(List<String> things) {
		List<String> copy = new ArrayList<>(things);
		copy.sort(String::compareTo);
		
		return copy;
	}
}
