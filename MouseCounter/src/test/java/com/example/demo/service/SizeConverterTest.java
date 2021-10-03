package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.AdultMiceEntity;

@ExtendWith(MockitoExtension.class)
class SizeConverterTest {

	@Mock
	private AdultMiceEntity mouseEntity;
	
	@InjectMocks
	private SizeConverter sizeConverter;
	
	@Test
	void adultをカタカナにしてにシングルクォーテーションを付けて返す() {
		doReturn("adult").when(mouseEntity).getSize();
		String expected = "'アダルト'" ;
		String actual = sizeConverter.sizeConverter1(mouseEntity);
		assertEquals(expected, actual);
	}
	
	@Test
	void youngをカタカナにしてにシングルクォーテーションを付けて返す() {
		doReturn("young").when(mouseEntity).getSize();
		String expected = "'ヤング'" ;
		String actual = sizeConverter.sizeConverter1(mouseEntity);
		assertEquals(expected, actual);
	}
	
	@Test
	void hopperをカタカナにしてにシングルクォーテーションを付けて返す() {
		doReturn("hopper").when(mouseEntity).getSize();
		String expected = "'ホッパー'" ;
		String actual = sizeConverter.sizeConverter1(mouseEntity);
		assertEquals(expected, actual);
	}
	
	@Test
	void アダルトにシングルクォーテーションを付けて返す() {
		doReturn("アダルト").when(mouseEntity).getSize();
		String expected = "'アダルト'" ;
		String actual = sizeConverter.sizeConverter2(mouseEntity);
		assertEquals(expected, actual);
	}
	
	@Test
	void ヤングにシングルクォーテーションを付けて返す() {
		doReturn("ヤング").when(mouseEntity).getSize();
		String expected = "'ヤング'" ;
		String actual = sizeConverter.sizeConverter2(mouseEntity);
		assertEquals(expected, actual);
	}
	
	@Test
	void ホッパーにシングルクォーテーションを付けて返す() {
		doReturn("ホッパー").when(mouseEntity).getSize();
		String expected = "'ホッパー'" ;
		String actual = sizeConverter.sizeConverter2(mouseEntity);
		assertEquals(expected, actual);
	}

}
