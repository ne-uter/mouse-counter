package com.example.demo.entity;

import javax.validation.constraints.NotNull;

public class AdultMiceEntity {
	private int id;
	private String registration_date;
	private String size;
	@NotNull
	private int male_of_stock;
	@NotNull
	private int female_of_stock;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void setMale_of_stock(int male_of_stock) {
		this.male_of_stock = male_of_stock;
	}
	public int getMale_of_stock() {
		return male_of_stock;
	}
	public void setFemale_of_stock(int female_of_stock) {
		this.female_of_stock = female_of_stock;
	}
	public int getFemale_of_stock() {
		return female_of_stock;
	}

}
