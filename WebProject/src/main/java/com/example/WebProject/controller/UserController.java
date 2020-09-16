
package com.example.WebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.WebProject.domain.UserDao;
import com.example.WebProject.domain.UserDto;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/")
	public String mainPage() {
		return "index";
	}

	@PostMapping("/user")
	public String userAdd(UserDto user) {
		System.out.print(user);
		userDao.insert(user);
		return "redirect:/user";
	}
	
	/*
	 * @PostMapping("/user") public String userDelete(UserDto user) {
	 * System.out.print(user); userDao.delete(user); return "redirect:/user"; }
	 */

	@GetMapping("/user")
	public String userlistPage(Model model) {
		
		// List<UserDto> dao = userDao.listForBeanPropertyRowMapper();
		
		model.addAttribute("users", userDao.listForBeanPropertyRowMapper());
		return "/userlist";
	}


}
