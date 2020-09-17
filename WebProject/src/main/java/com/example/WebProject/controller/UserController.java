
package com.example.WebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.WebProject.domain.UserDao;
import com.example.WebProject.domain.UserDto;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/add")
	public String userAdd(UserDto user) {
		System.out.print(user);
		userDao.insert(user);
		return "redirect:/";
	}

	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("users", userDao.listForBeanPropertyRowMapper());
		return "index";
	}

	
	
	@PostMapping("/update")
	public String userUpdate(UserDto user) {
		System.out.print(user);
		userDao.update(user);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String userDelete(int userNum) {
		System.out.print(userNum);
		userDao.delete(userNum);
		return "redirect:/";
	}

	@GetMapping("/addform")
	public String addPage() {
		return "addform";
	}

	@GetMapping("/updateform")
	public String updatePage(Model model) {
		model.addAttribute("users", userDao.listForBeanPropertyRowMapper());
		return "updateform";
	}



}
