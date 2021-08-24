package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AdultMiceEntity;
import com.example.demo.entity.BabyMiceEntity;
import com.example.demo.entity.MiceTotalEntity;
import com.example.demo.service.BabyMiceService;
import com.example.demo.service.MouseService;

@Controller
public class MCController {

	@Autowired
	MouseService mouseService; //Serviceインスタンス呼び出す用
	
	@Autowired
	BabyMiceService babyMiceService;
	
	@ModelAttribute
	AdultMiceEntity entity() {
		return new AdultMiceEntity();
	}
	
	@ModelAttribute
	MiceTotalEntity miceTotalEntity() {
		return new MiceTotalEntity();
	}
	
	//アクセスすると一覧表示
	@GetMapping("/")
	public String index(Model model, BabyMiceEntity babyMiceEntity) {
		List<AdultMiceEntity> list = mouseService.selectLatest10();
		model.addAttribute("adult", list);
		List<MiceTotalEntity> totalList = mouseService.miceTotal();
		model.addAttribute("total", totalList);
		List<BabyMiceEntity> babiesList = babyMiceService.selectAll();
		model.addAttribute("baby", babiesList);
		Map<String, Integer> babiesTotal = babyMiceService.babiesTotal();
		model.addAttribute("babiesTotal", babiesTotal);
		return "view";
	}
	
	@PostMapping(value = "/", params = "pinkLitters")
	public String postPink(@Validated BabyMiceEntity babyMiceEntity,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
	
			return index(model, babyMiceEntity);
		}
		babyMiceService.babyRegister(babyMiceEntity);
		return "redirect:/";
	}
	
	
	//データ登録
	@PostMapping(value = "/", params = "create")
	public String postCreate(@Validated AdultMiceEntity mouseEntity,BindingResult bindingResult,Model model) {
		validation(mouseEntity, bindingResult);
		mouseService.mouseRegister(mouseEntity);
		return "redirect:/"; //表をリロードし、F5した時にフォームの再送信を防ぐ
	}
	
	//データ更新
	@PostMapping(value = "/", params = "update")
	public String postUpdate(@Validated AdultMiceEntity mouseEntity,BindingResult bindingResult,Model model) {
		validation(mouseEntity, bindingResult);
		mouseService.mouseDataUpdate(mouseEntity);
		return "redirect:/";
	}
	
	//データ削除
	@PostMapping(value = "/", params = "delete")
	public String postDelete(@Validated AdultMiceEntity mouseEntity,BindingResult bindingResult,Model model) {
		validation(mouseEntity, bindingResult);
		mouseService.mouseDataDelete(mouseEntity);
		return "redirect:/";
	}
	
	//入力チェック(♂もしくは♀の匹数が空で送られてきたら0を代入する)
	private void validation(AdultMiceEntity mouseEntity,BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors("male_of_stock")) {
			mouseEntity.setMale_of_stock(0);
		}
		if (bindingResult.hasFieldErrors("female_of_stock")) {
			mouseEntity.setFemale_of_stock(0);
		}
	}
}