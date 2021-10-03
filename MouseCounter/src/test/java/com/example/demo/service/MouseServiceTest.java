package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repository.AdultMiceMapper;

@ExtendWith(MockitoExtension.class)
class MouseServiceTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private AdultMiceMapper adultMiceMapper;
	
	@InjectMocks
	private MouseService mouseService;
	
	@Test
	void miceTotalでアダルトがtotalListに入る() {
		when(adultMiceMapper.selectTotal("'アダルト'").getSize()).thenReturn("アダルト");
		String expected = "アダルト";
		String actual = mouseService.miceTotal().get(0).getSize();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでアダルトのオス合計数がtotalListに入る() {
		when(adultMiceMapper.selectTotal("'アダルト'").getMales_total()).thenReturn(1);
		int expected = 1;
		int actual = mouseService.miceTotal().get(0).getMales_total();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでアダルトのメス合計数がtotalListに入る() {
		when(adultMiceMapper.selectTotal("'アダルト'").getFemales_total()).thenReturn(2);
		int expected = 2;
		int actual = mouseService.miceTotal().get(0).getFemales_total();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでヤングがtotalListに入る() {
		when(adultMiceMapper.selectTotal("'ヤング'").getSize()).thenReturn("ヤング");
		String expected = "ヤング";
		String actual = mouseService.miceTotal().get(1).getSize();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでヤングのオス合計数がtotalListに入る() {
		when(adultMiceMapper.selectTotal("'ヤング'").getMales_total()).thenReturn(1);
		int expected = 1;
		int actual = mouseService.miceTotal().get(1).getMales_total();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでヤングのメス合計数がtotalListに入る() {
		when(adultMiceMapper.selectTotal("'ヤング'").getFemales_total()).thenReturn(2);
		int expected = 2;
		int actual = mouseService.miceTotal().get(1).getFemales_total();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでホッパーがtotalListに入る() {
		when(adultMiceMapper.selectTotal("'ホッパー'").getSize()).thenReturn("ホッパー");
		String expected = "ホッパー";
		String actual = mouseService.miceTotal().get(2).getSize();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでホッパーのオス合計数がtotalListに入る() {
		when(adultMiceMapper.selectTotal("'ホッパー'").getMales_total()).thenReturn(1);
		int expected = 1;
		int actual = mouseService.miceTotal().get(2).getMales_total();
		assertEquals(expected, actual);
	}
	
	@Test
	void miceTotalでホッパーのメス合計数がtotalListに入る() {
		when(adultMiceMapper.selectTotal("'ホッパー'").getFemales_total()).thenReturn(2);
		int expected = 2;
		int actual = mouseService.miceTotal().get(2).getFemales_total();
		assertEquals(expected, actual);
	}
}
