package com.example.WebProject.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.ListDto;
import com.example.WebProject.service.UserService;

@Controller
public class ListController {

	@Autowired
	private ListDao listDao;

	@GetMapping("/")
	public String login() {
		return "loginform";
	}

	@GetMapping("/list")
	public String checkLogin(Model model) {
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper());
		return "index";
	}

	/*
	 * @PostMapping("/") public String chceckLogin(@RequestParam("id") String
	 * id, @RequestParam String password, HttpServletResponse response, HttpSession
	 * session) throws Exception { int check = userService.userCheck(id, password);
	 * 
	 * if (check != UserService.ID_AND_PASSWD_OK) { String message = ""; switch
	 * (check) { case UserService.ONLY_PASSWD_FAIL: message = "패스워드 틀림"; break; case
	 * UserService.ID_AND_PASSWD_FAIL: message = "아이디 없음"; break; }
	 * 
	 * response.setContentType("text/html; charset=UTF-8");
	 * 
	 * PrintWriter out = response.getWriter(); return null; }
	 * session.setAttribute("id", id);
	 * 
	 * return "redirect:/list"; }
	 * 
	 * @GetMapping("/list") public String mainPage(Model model, HttpSession session)
	 * { String sessionKey = session.getId(); session.setAttribute("id", "test");
	 * System.out.println(session.getAttribute("id"));
	 * System.out.println(session.getId()); model.addAttribute("lists",
	 * listDao.listForBeanPropertyRowMapper()); String a = "test"; if
	 * (session.getAttribute("id") == a) { return "index"; } else { return
	 * "loginform"; } }
	 */

	@PostMapping("/add")
	public String listAdd(ListDto list) {
		System.out.print(list);
		listDao.insert(list);
		return "redirect:/list";
	}

	@PostMapping("/update")
	public String listUpdate(ListDto list) {
		System.out.print(list);
		listDao.update(list);
		return "redirect:/list";
	}

	@GetMapping("/delete")
	public String listDelete(int listNum) {
		System.out.print(listNum);
		listDao.delete(listNum);
		return "redirect:/list";
	}

	@GetMapping("/addform")
	public String addPage() {
		return "addform";
	}

	@GetMapping("/updateform")
	public String updatePage(Model model) {
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper());
		return "updateform";
	}

}