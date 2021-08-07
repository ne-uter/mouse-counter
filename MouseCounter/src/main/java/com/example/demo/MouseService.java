package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MouseService {
	
	@Autowired
	private MouseRepository mouseRepository;
	
	public List<MouseEntity> read() {
		return mouseRepository.selectMouse();
		
	}
	
	public void create(MouseEntity mouseEntity) {
		mouseRepository.insertMouse(mouseEntity);
	}
}
