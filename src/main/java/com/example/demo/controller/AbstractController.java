package com.example.demo.controller;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class AbstractController<T extends AbstractEntity> {

	private Long id = 1l;
	private Map<Long, T> repo = new HashMap<>();

	public AbstractController() {
		super();
	}

	ResponseEntity<Collection<T>> getAll() {
		return ResponseEntity.ok().body(repo.values());
	}

	ResponseEntity<T> get(@PathVariable Long id) {
		Optional<T> insight = Optional.ofNullable(repo.get(id));
		return ResponseEntity.of(insight);
	}

	ResponseEntity<T> post(@RequestBody T entity) {
		Long entityId = id++;
		entity.setId(entityId);
		repo.put(entityId, entity);
		return ResponseEntity.ok().body(entity);
	}

	ResponseEntity<T> put(@PathVariable Long id, @RequestBody T entity) {
		T fromRepo = repo.get(id);
		if (fromRepo == null) return ResponseEntity.notFound().build();
		entity.setId(id);
		repo.put(id, entity);
		return ResponseEntity.ok().body(entity);
	}

	ResponseEntity<T> patch(@PathVariable Long id, @RequestBody T entity, Class<T> clazz) {
		T fromRepo = repo.get(id);
		if (fromRepo == null) return ResponseEntity.notFound().build();
		
		for (Field field : clazz.getDeclaredFields()) {
			try {
				Object value = field.get(entity);
				if (value != null) field.set(fromRepo, value);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return ResponseEntity.ok().body(fromRepo);
	}

	ResponseEntity<T> delete(@PathVariable Long id) {
		T deletedInsight = repo.remove(id);
		return (deletedInsight == null) ? 
				ResponseEntity.noContent().build() : 
				ResponseEntity.ok().build();
	}

}

class AbstractEntity {
	Long id;

	public AbstractEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}