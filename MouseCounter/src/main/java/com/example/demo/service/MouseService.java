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
	@Autowired
	private SizeConverter sizeConverter;
	
	public List<MouseEntity> selectAll() {
		return mouseRepository.selectAll();
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
		totalCalculation(mouseEntity);
	}
	
	public void mouseDataUpdate(MouseEntity mouseEntity) {
		mouseRepository.update(mouseEntity);
		totalCalculationCorrection(mouseEntity);
	}
	
	public void mouseDataDelete(MouseEntity mouseEntity) {
		mouseRepository.selectOne(mouseEntity);
		totalCalculationCorrection(mouseEntity);
		mouseRepository.delete(mouseEntity);
	}
	
	public void totalCalculation(MouseEntity mouseEntity) {
		//登録された変更値を合計値に合算してテーブルに戻す
		MiceTotalEntity totalEntity = mouseRepository.selectTotal(sizeConverter.sizeConverter1(mouseEntity));
		totalEntity.setMales_total(totalEntity.getMales_total() + mouseEntity.getMale_of_stock());
		totalEntity.setFemales_total(totalEntity.getFemales_total() + mouseEntity.getFemale_of_stock());
		totalEntity.setSize(sizeConverter.sizeConverter2(mouseEntity));
		mouseRepository.totalUpdate(totalEntity);
	}
	public void totalCalculationCorrection(MouseEntity mouseEntity) {
		mouseEntity = mouseRepository.selectOne(mouseEntity);
		MiceTotalEntity totalEntity = mouseRepository.selectTotal(sizeConverter.sizeConverter1(mouseEntity));
		totalEntity.setMales_total(totalEntity.getMales_total() - mouseEntity.getMale_of_stock());
		totalEntity.setFemales_total(totalEntity.getFemales_total() - mouseEntity.getFemale_of_stock());
		totalEntity.setSize(sizeConverter.sizeConverter2(mouseEntity));
		mouseRepository.totalUpdate(totalEntity);
		
	}
}
