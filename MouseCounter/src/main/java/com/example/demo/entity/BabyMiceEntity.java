package com.example.demo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class BabyMiceEntity {

	private int id;
	private String birthday;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
