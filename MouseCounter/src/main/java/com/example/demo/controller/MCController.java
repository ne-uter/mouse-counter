package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MiceTotalEntity;
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
	
	@ModelAttribute
	MiceTotalEntity miceTotalEntity() {
		return new MiceTotalEntity();
	}
	
	//アクセスすると一覧表示
	@GetMapping("/")
	public String index(Model model) {
		List<MouseEntity> list = mouseService.selectAll();
		model.addAttribute("mouse", list);
		List<MiceTotalEntity> totalList = mouseService.miceTotal();
		model.addAttribute("total", totalList);
		return "view";
	}
	
	//データ登録
	@PostMapping(value = "/", params = "create")
	public String postCreate(@Validated MouseEntity mouseEntity,BindingResult bindingResult,Model model) {
		validation(mouseEntity, bindingResult);
		mouseService.mouseRegister(mouseEntity);
		index(model); //表をリロード
		return "redirect:/";
		
	}
	
	//データ更新
	@PostMapping(value = "/", params = "update")
	public String postUpdate(@Validated MouseEntity mouseEntity,BindingResult bindingResult,Model model) {
		validation(mouseEntity, bindingResult);
		mouseService.mouseDataUpdate(mouseEntity);
		index(model);
		return "redirect:/";
	}
	
	//データ削除
	@PostMapping(value = "/", params = "delete")
	public String postDelete(@Validated MouseEntity mouseEntity,BindingResult bindingResult,Model model) {
		validation(mouseEntity, bindingResult);
		mouseService.mouseDataDelete(mouseEntity);
		index(model);
		return "redirect:/";
	}
	
	//入力チェック(♂もしくは♀の匹数が空で送られてきたら0を代入する)
	private void validation(MouseEntity mouseEntity,BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("male_of_stock")) {
			mouseEntity.setMale_of_stock(0);
		}
		if (bindingResult.hasFieldErrors("female_of_stock")) {
			mouseEntity.setFemale_of_stock(0);
		}
	}
}