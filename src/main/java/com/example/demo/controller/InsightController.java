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
public class InsightController extends AbstractController<Insight> {
	
	@Override
	@GetMapping("/insight")
	ResponseEntity<Collection<Insight>> getAll() {
		return super.getAll();
	}
	
	@Override
	@GetMapping("/insight/{id}")
	ResponseEntity<Insight> get(@PathVariable Long id) {
		return super.get(id);
	}
	
	@Override
	@PostMapping("/insight")
	ResponseEntity<Insight> post(@RequestBody Insight insight) {
		return super.post(insight);
	}
	
	@Override
	@PutMapping("/insight/{id}")
	ResponseEntity<Insight> put(@PathVariable Long id, @RequestBody Insight insight) {
		return super.put(id, insight);
	}
	
	@PatchMapping("/insight/{id}")
	ResponseEntity<Insight> patch(@PathVariable Long id, @RequestBody Insight insight) {
		return super.patch(id, insight, Insight.class);
	}
	
	@Override
	@DeleteMapping("/insight/{id}")
	ResponseEntity<Insight> delete(@PathVariable Long id) {
		return super.delete(id);
	}
}

class Insight extends AbstractEntity {
	String text;
	String date;
	Boolean archived;
	
	public Insight(Long id, String text, String date, Boolean archived) {
		super(id);
		this.text = text;
		this.date = date;
		this.archived = archived;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
