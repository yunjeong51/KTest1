package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/quiz/*")
@Log4j

public class QuizController {

	@GetMapping("test1")
		public void test1() {
			
		}
	
	
	@GetMapping("/test2")
	public String test2() {
		
		return "/quiz/test3";
		
	}
	
	@GetMapping("/test3")
	public String test3() {
		
		return "test3";
		
	}
	@GetMapping("test10")
	public void test10() {
		
	}
	@RequestMapping("test11")
	public void test11(int num1,int num2,Model model) {
		int sum=0;
		for(int i=num1; i<=num2; i++) {
			sum +=i;
		}
		model.addAttribute("sum", sum);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		
	}
	@RequestMapping("go")
	public void go() {
		
	}
	
	@RequestMapping("gogo")
	public void gogo() {
		
	}
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
	

