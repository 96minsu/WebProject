package com.example.WebProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.UserDao;

@Controller
public class ajaxController {

	@Autowired
	ListDao listDao;
	
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

	/*
	 * @RequestMapping("/contentform") public String sendData(Model model) {
	 * model.addAttribute("lists", listDao.listForBeanPropertyRowMapper()); return
	 * "contentform"; }
	 */
}
