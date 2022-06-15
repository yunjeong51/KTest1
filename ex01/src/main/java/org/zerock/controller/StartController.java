package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class StartController {
	@RequestMapping("start")
	public void start() {
		
	}
	@RequestMapping("/ok/result")
	public String okresult(int num1,int num2,Model model) {
		int a=num1+num2;
		int b=num1-num2;
		int c=num1*num2;
		int d=num1/num2;
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", c);
		model.addAttribute("d", d);
		
		return "abc";
		
	}
	
	

}
