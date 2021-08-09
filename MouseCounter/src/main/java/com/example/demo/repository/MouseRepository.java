package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MouseEntity;

@Mapper
public interface MouseRepository {

	List<MouseEntity> select();
	
	boolean insert(MouseEntity mouseEntity);
	
}
