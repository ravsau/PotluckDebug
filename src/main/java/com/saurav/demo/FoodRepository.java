package com.saurav.demo;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<FoodPotluck, Long> {
	
	Iterable<FoodPotluck> findByPersonName( String string);
}
