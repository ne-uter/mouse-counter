package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AdultMiceEntity;
import com.example.demo.entity.MiceTotalEntity;
import com.example.demo.repository.AdultMiceMapper;

@Service
public class MouseService {
	
	@Autowired
	private AdultMiceMapper adultMiceMapper;
	@Autowired
	private SizeConverter sizeConverter;
	
	public List<AdultMiceEntity> selectLatest10() {
		return adultMiceMapper.selectLatest10();
	}
	public List<MiceTotalEntity> miceTotal() {
		List<MiceTotalEntity> totalList = new ArrayList<MiceTotalEntity>();
		List<String> sizeList = new ArrayList<String>();
		sizeList.add("'アダルト'");
		sizeList.add("'ヤング'");
		sizeList.add("'ホッパー'");
		for (String string : sizeList) {
			totalList.add(adultMiceMapper.selectTotal(string));
		}
		return totalList;
	}
	@Transactional(rollbackFor = Exception.class)
	public void mouseRegister(AdultMiceEntity mouseEntity) {
		adultMiceMapper.insert(mouseEntity);
		totalCalculation(mouseEntity);
	}
	@Transactional(rollbackFor = Exception.class)
	public void mouseDataUpdate(AdultMiceEntity mouseEntity) {
		AdultMiceEntity oldData = new AdultMiceEntity();
		oldData.setId(mouseEntity.getId());
		oldData = adultMiceMapper.selectOne(oldData);
		totalCalculationCorrection(oldData);
		mouseEntity.setSize(oldData.getSize());
		adultMiceMapper.update(mouseEntity);
		totalCalculation(mouseEntity);
	}
	@Transactional(rollbackFor = Exception.class)
	public void mouseDataDelete(AdultMiceEntity mouseEntity) {
		adultMiceMapper.selectOne(mouseEntity);
		totalCalculationCorrection(mouseEntity);
		adultMiceMapper.delete(mouseEntity);
	}
	
	public void totalCalculation(AdultMiceEntity mouseEntity) {
		//登録された変更値を合計値に合算してテーブルに戻す
		MiceTotalEntity totalEntity = adultMiceMapper.selectTotal(sizeConverter.sizeConverter1(mouseEntity));
		totalEntity.setMales_total(totalEntity.getMales_total() + mouseEntity.getMale_of_stock());
		totalEntity.setFemales_total(totalEntity.getFemales_total() + mouseEntity.getFemale_of_stock());
		totalEntity.setSize(sizeConverter.sizeConverter2(mouseEntity));
		adultMiceMapper.totalUpdate(totalEntity);
	}
	public void totalCalculationCorrection(AdultMiceEntity mouseEntity) {
		mouseEntity = adultMiceMapper.selectOne(mouseEntity);
		MiceTotalEntity totalEntity = adultMiceMapper.selectTotal(sizeConverter.sizeConverter1(mouseEntity));
		totalEntity.setMales_total(totalEntity.getMales_total() - mouseEntity.getMale_of_stock());
		totalEntity.setFemales_total(totalEntity.getFemales_total() - mouseEntity.getFemale_of_stock());
		totalEntity.setSize(sizeConverter.sizeConverter2(mouseEntity));
		adultMiceMapper.totalUpdate(totalEntity);
		
	}
}
