package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MouseEntity;
import com.example.demo.repository.MouseRepository;

@Service
public class MouseService {
	
	@Autowired
	private MouseRepository mouseRepository;
	
	public List<MouseEntity> selectAll() {
		return mouseRepository.select();
		
	}
	
	public void mouseRegister(MouseEntity mouseEntity) {
		mouseRepository.insert(mouseEntity);
	}
}
