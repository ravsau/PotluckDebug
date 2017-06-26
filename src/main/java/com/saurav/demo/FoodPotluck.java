package com.saurav.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodPotluck {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	
	private String personName;
	private String food;

	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public long getId() {
		return id;
	}
	
	

	
	
	

}
