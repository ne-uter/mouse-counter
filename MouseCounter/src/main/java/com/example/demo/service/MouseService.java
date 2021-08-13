package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MiceTotalEntity;
import com.example.demo.entity.MouseEntity;
import com.example.demo.repository.MouseRepository;

@Service
public class MouseService {
	
	@Autowired
	private MouseRepository mouseRepository;
	
	public List<MouseEntity> selectAll() {
		return mouseRepository.select();
	}
	public List<MiceTotalEntity> miceTotal() {
		List<MiceTotalEntity> totalList = new ArrayList<MiceTotalEntity>();
		List<String> sizeList = new ArrayList<String>();
		sizeList.add("'アダルト'");
		sizeList.add("'ヤング'");
		sizeList.add("'ホッパー'");
		for (String string : sizeList) {
			totalList.add(mouseRepository.selectTotal(string));
		}
		return totalList;
	}
	
	
	public void mouseRegister(MouseEntity mouseEntity) {
		mouseRepository.insert(mouseEntity);
	}
	
	public void mouseDataUpdate(MouseEntity mouseEntity) {
		mouseRepository.update(mouseEntity);
	}
	
	public void mouseDataDelete(MouseEntity mouseEntity) {
		mouseRepository.delete(mouseEntity);
	}
}
