package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MCController {

	@Autowired
	MouseService mouseService; //Serviceインスタンス呼び出す用
	
	@ModelAttribute
	MouseEntity entity() {
		return new MouseEntity();
	}
	
	//アクセスすると一覧表示
	@RequestMapping("/")
	public String index(Model model) {
		List<MouseEntity> list = mouseService.read();
		model.addAttribute("mouse", list);
		return "view";
	}
	
	//データ登録
	@PostMapping(value = "/")
	public String postIndex(@ModelAttribute MouseEntity mouseEntity, Model model) {
		mouseService.create(mouseEntity);
		 return "view";
		
	}
}