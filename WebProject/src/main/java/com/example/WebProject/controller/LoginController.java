
package com.example.WebProject.controller;

import java.io.PrintWriter;

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

	@GetMapping("/list")
	public String checkLogin(Model model) {
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper());
		return "index";
	}

	@GetMapping("/login")
	public String login2() {
		System.out.println(1);
		return "loginform";
	}
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam String password, HttpServletResponse response,
			HttpSession session) throws Exception {
		int check = userService.userCheck(id, password);
		System.out.println(1);
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
		System.out.println(1);
		if (id == null) {
			return "redirect:/login";
		}
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper());
		return "index";
	}

}
