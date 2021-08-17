package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MiceTotalEntity;
import com.example.demo.entity.MouseEntity;

@Mapper
public interface MouseRepository {

	List<MouseEntity> selectAll();
	
	MiceTotalEntity selectTotal(String size);
	
	MouseEntity selectOne(MouseEntity mouseEntity);
	
	void insert(MouseEntity mouseEntity);
	
	void totalUpdate(MiceTotalEntity miceTotalEntity);
	
	void update(MouseEntity mouseEntity);
	
	void delete(MouseEntity mouseEntity);
}
