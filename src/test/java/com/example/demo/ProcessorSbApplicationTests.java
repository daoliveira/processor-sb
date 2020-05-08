package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ProductService;

@SpringBootTest
class ProcessorSbApplicationTests {
	
	@Autowired
	ProductService productService;

	@Test
	void contextLoads() {
		List<String> original = Arrays.asList("a", "d", "aa", "c");
		
		List<String> sorted = productService.sortThings(original);
		
		assertEquals("a", sorted.get(0));
		assertEquals("aa", sorted.get(1));
		assertEquals("c", sorted.get(2));
		assertEquals("d", sorted.get(3));
	}

}
