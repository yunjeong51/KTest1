package org.zerock.controller;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("기본요청....");
	}
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic을 요청하셨습니다.");
	}
	
	@GetMapping("basicOnlyGet")
	public void basicGet2() {
		log.info("basicOnlyGet을 요청하셨습니다. 저는 get 요청만 받아요....");
	}
	
	// ~/sample/ex01?name=aaa&age=10
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto){
		log.info("객체로 수집한 데이터는" + dto);
		return "ex01"; // 페이지 지정시는 /빠져도 무조건 절대경로다.
	}
	
	// ~/sample/ex02?name=aaa&age=10
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name, @RequestParam("age")int age) {
		log.info("파라미터 수집 및 변환 확인: "+ name + " "+age);
		return "ex02";
	}
	
	// ~/sample/ex02List?ids=111&ids=222&ids=333 cf> 체크박스 수집
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("리스트 수집"+ids);
		return "ex02List";
	}
	// ~/sample/ex02Array?ids=111&ids=222&ids=333
	@GetMapping("ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info(ids); //배열 객체 주소가 출력된다.
		
		for(String temp : ids) {
			log.info(temp);
		}
		log.info("배열수집"+Arrays.toString(ids));
		return "ex02Array";
	}
	
	// ~/sample/ex02Bean?list[0].name=aaa&list[0].age=10&list[1].name=bbb
	//테스트 할때는 [ 는 %5B  ]는 %5D로 변경해서 테스트 
	// ~/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb
	@GetMapping("ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		log.info("객체 리스트를 자동으로 수집해 보았습니다. 값은:"+list);
	
	}
	
	// ~/sample/ex03?title=test&dueDate=2022-5-31
	@GetMapping("ex03")
	public void ex03(TodoDTO todo) {
		log.info("수집데이터 확인:" + todo);
		
	}
	
	//날짜처리방법 설정
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class,
//				new CustomDateEditor(dateFormat, false));
//	}
//	
	
	// ~/sample/ex04?name=aaa&age=21&page=3
	@GetMapping("/ex04")
	public void ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("샘플DTO수집되었나?: "+dto);
		log.info("page는 수집되었나?: "+page);
		
	}
	// ~/sample/re?age=10 -> 수집한 데이터를 가지고 ~/sample/re1으로 요청
	@GetMapping("/re")
	public String re(int age, RedirectAttributes rttr) {
		log.info("수집된값확인: "+age);
		rttr.addFlashAttribute("age", age);	//한번만 사용하도록 전송(새로고침을 하면 값이 사라짐)
		return "redirect:/sample/re1";
	}
	
	@RequestMapping("/re1")
	public void re1() {
	
	}
	
	
}
