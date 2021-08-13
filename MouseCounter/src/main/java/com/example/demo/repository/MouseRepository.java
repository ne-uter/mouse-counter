package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MiceTotalEntity;
import com.example.demo.entity.MouseEntity;

@Mapper
public interface MouseRepository {

	List<MouseEntity> select();
	
	MiceTotalEntity selectTotal(String size);
	
	boolean insert(MouseEntity mouseEntity);
	
	void update(MouseEntity mouseEntity);
	
	void delete(MouseEntity mouseEntity);
	
}
