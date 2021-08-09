package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MouseEntity;
import com.example.demo.service.MouseService;

@Controller
public class MCController {

	@Autowired
	MouseService mouseService; //Serviceインスタンス呼び出す用
	
	@ModelAttribute
	MouseEntity entity() {
		return new MouseEntity();
	}
	
	//アクセスすると一覧表示
	@GetMapping("/")
	public String index(Model model) {
		List<MouseEntity> list = mouseService.selectAll();
		model.addAttribute("mouse", list);
		return "view";
	}
	
	//データ登録
	@PostMapping("/")
	public String postIndex(MouseEntity mouseEntity, Model model) {
		mouseService.mouseRegister(mouseEntity);
		index(model); //表をリロード
		return "view";
		
	}
}