
package com.example.WebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.WebProject.domain.UserDao;
import com.example.WebProject.domain.UserDto;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/")
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

	@GetMapping("/a")
	public String userDelete(int userNum) {
		System.out.print(userNum);
		userDao.delete(userNum);

		return "redirect:/";
	}

	@GetMapping("/addUser")
	public String addPage() {
		return "addUser";
	}

	/*
	 * @PostMapping("/user") public String userAdd(UserDto user) {
	 * System.out.print(user); userDao.insert(user); return "redirect:/user"; }
	 */

	/*
	 * @GetMapping("/user") public String userlistPage(Model model) {
	 * 
	 * // List<UserDto> dao = userDao.listForBeanPropertyRowMapper();
	 * 
	 * model.addAttribute("users", userDao.listForBeanPropertyRowMapper()); return
	 * "/userlist"; }
	 */

}
