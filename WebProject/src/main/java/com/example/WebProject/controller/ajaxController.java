package com.example.WebProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.ListDto;
import com.example.WebProject.domain.UserDao;
import com.example.WebProject.domain.dto.TestDTO;

@Controller
public class ajaxController {

	@Autowired
	ListDao listDao;

	@GetMapping("/kendo")
	public String kendoTest() {
		return "hello";
	}

	@GetMapping("/kendo1")
	public String kendoTest1() {
		return "kendo1";
	}

	@GetMapping("/kendo2")
	public String kendoTest2() {
		return "kendo2";
	}

	@GetMapping("/button")
	public String button() {
		return "button";
	}

	@ResponseBody
	@GetMapping("/jsonData")
	public List jsonData() {

		List<ListDto> list = listDao.listForBeanPropertyRowMapper();

		return list;
	}

	@PostMapping("/addform")
	public String goAddform() {
		return "addform_ajax";
	}

	@PostMapping("/updateform")
	public String goUpdateform(Model model) {
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper().get(0));
		System.out.println(listDao.listForBeanPropertyRowMapper().get(0));

		return "updateform_ajax";
	}

}
