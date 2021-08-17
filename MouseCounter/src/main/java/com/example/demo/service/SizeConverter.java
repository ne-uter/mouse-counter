package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.MouseEntity;

@Service
public class SizeConverter {
	
	private String sizeConversion;

	public String sizeConverter1(MouseEntity mouseEntity) {
		if (mouseEntity.getSize().equals("adult")) {
			sizeConversion = "'アダルト'";
		} else if (mouseEntity.getSize().equals("young")) {
			sizeConversion = "'ヤング'";
		} else if (mouseEntity.getSize().equals("hopper")) {
			sizeConversion = "'ホッパー'";
		}
		return getSizeConversion();
	}
	public String sizeConverter2(MouseEntity mouseEntity) {
		if (mouseEntity.getSize().equals("アダルト")) {
			sizeConversion = "'アダルト'";
		} else if (mouseEntity.getSize().equals("ヤング")) {
			sizeConversion = "'ヤング'";
		} else if (mouseEntity.getSize().equals("ホッパー")) {
			sizeConversion = "'ホッパー'";
		}
		return getSizeConversion();
	}
	
	public String getSizeConversion() {
		return sizeConversion;
	}
	public void setSizeConversion(String sizeConversion) {
		this.sizeConversion = sizeConversion;
	}
}
