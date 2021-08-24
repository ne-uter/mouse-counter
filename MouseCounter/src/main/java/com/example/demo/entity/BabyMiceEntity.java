package com.example.demo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class BabyMiceEntity {

	private int id;
	private String registration_date;
	private String size;
	@NotNull(message = "正の整数を入力してください")
	@Positive(message = "正の整数を入力するでちゅう")
	private int litters;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getLitters() {
		return litters;
	}
	public void setLitters(int litters) {
		this.litters = litters;
	}
}
