package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MCController {

	@Autowired
	MouseRepository mouseRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<MouseEntity> list = mouseRepository.selectMouse();
		model.addAttribute("mouse", list);
		return "view";
	}
}
