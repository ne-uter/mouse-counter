package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repository.BabyMiceMapper;

@ExtendWith(MockitoExtension.class)
class BabyMiceServiceTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private BabyMiceMapper babyMiceMapper;
	
	@InjectMocks
	private BabyMiceService babyMiceService;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	void babiesTotalでホッパーの腹数がbabiesListに入る() {
		when(babyMiceMapper.selectAll().get(0).getSize()).thenReturn("hopper");
		when(babyMiceMapper.selectAll().get(0).getLitters()).thenReturn(1);
		int expected = 1;
		int actual = babyMiceService.babiesTotal().get("ホッパー");
		assertEquals(expected, actual);
	}

}
