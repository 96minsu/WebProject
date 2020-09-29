package com.example.WebProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebProject.domain.TestDto;
import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.ListDto;

@Controller
public class testController {

	@Autowired
	ListDao listDao;
	
	@GetMapping("/button")
	public String button() {
		return "button";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	@ResponseBody
	@GetMapping("/jsonData")
	public List jsonData() {

		List<ListDto> list = new ArrayList<ListDto>();
		
		for (int i = 0; i < listDao.getListCount(); i++) {
			list.add(listDao.listForBeanPropertyRowMapper().get(i));
		}
		System.out.println(list);
		return list;
	}
	

	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}

	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}

	@GetMapping("/hi")
	public String hi() {
		return "helloworld";
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/test3") public ListDto test3() { ListDto listDto = new
	 * ListDto();
	 * 
	 * listDto.setListNum(3); listDto.setListName("테스트3");
	 * 
	 * return listDto; }
	 */


	/*
	 * @RequestMapping("/3")
	 * 
	 * @ResponseBody public List<TestDto> test333(ListDto listDto, Model model) {
	 * List<TestDto> test = new ArrayList<TestDto>(); model.addAttribute("lists",
	 * listDao.listForBeanPropertyRowMapper());
	 * 
	 * System.out.println(listDao.testNum(listDto)); for(int i=0;
	 * i<listDao.getListCount(); i++) { test.add(i, new TestDto(1, "1111"));
	 * 
	 * } return test; }
	 */

	@GetMapping("/test5")
	@ResponseBody
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "111");
		map.put("2", 222);
		return map;
	}

	@GetMapping("/test4")
	public String test4() {
		System.out.println(listDao.listForBeanPropertyRowMapper());
		return "test4";
	}

	@PostMapping("/test4")
	@ResponseBody
	public String testAction() {
		System.out.println(listDao.listForBeanPropertyRowMapper());
		return "아";
	}

	@GetMapping("/aaa")
	@ResponseBody
	public String aaaa() {
		return "<html><body><h1>Hello, ResponseBody!</h1></body></html>";
	}

}
