package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.BabyMiceEntity;

@Mapper
public interface BabyMiceMapper {

	List<BabyMiceEntity> selectAll();
	
	void insert(BabyMiceEntity babyMiceEntity);
	
	void update(BabyMiceEntity babyMiceEntity);
	
	void autoUpdate(BabyMiceEntity babyMiceEntity);
}
