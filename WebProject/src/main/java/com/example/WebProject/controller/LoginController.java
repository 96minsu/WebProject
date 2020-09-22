
package com.example.WebProject.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.UserDao;
import com.example.WebProject.domain.UserDto;
import com.example.WebProject.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private ListDao listDao;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String login() {
		return "loginform";
	}

	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam String password, HttpServletResponse response,
			HttpSession session) throws Exception {
		int check = userService.userCheck(id, password);
		System.out.println(check);
		if (check != UserService.ID_AND_PASSWD_OK) {
			String message = "";
			switch (check) {
			case UserService.ONLY_PASSWD_FAIL:
				message = "패스워드 틀림";
				break;
			case UserService.ID_AND_PASSWD_FAIL:
				message = "아이디 없음";
				break;
			}

			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("alert('" + message + "');");
			out.println("history.back()");
			return null;
		}
		session.setAttribute("id", id);

		return "redirect:/index";
	}

	@RequestMapping("index")
	public String main(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		UserDao userDao = null;
		if (id == null) {
			return "redirect:/login";
		}
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper());
		model.addAttribute("value",id);
		System.out.println(id); 
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "loginform";
	}
}
