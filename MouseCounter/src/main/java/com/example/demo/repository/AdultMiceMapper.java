package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.AdultMiceEntity;
import com.example.demo.entity.MiceTotalEntity;

@Mapper
public interface AdultMiceMapper {

	List<AdultMiceEntity> selectLatest10();
	
	MiceTotalEntity selectTotal(String size);
	
	AdultMiceEntity selectOne(AdultMiceEntity mouseEntity);
	
	void insert(AdultMiceEntity mouseEntity);
	
	void totalUpdate(MiceTotalEntity miceTotalEntity);
	
	void update(AdultMiceEntity mouseEntity);
	
	void delete(AdultMiceEntity mouseEntity);
}
