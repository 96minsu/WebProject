
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

import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.ListDto;

@Controller
public class ListController {

	@Autowired
	private ListDao listDao;

	@PostMapping("/add")
	public String listAdd(ListDto list) {
		System.out.print(list);
		listDao.insert(list);
		return "redirect:/";
	}

	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("lists", listDao.listForBeanPropertyRowMapper());
		return "index";
	}

	
	
	@PostMapping("/update")
	public String listUpdate(ListDto list) {
		System.out.print(list);
		listDao.update(list);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String listDelete(int listNum) {
		System.out.print(listNum);
		listDao.delete(listNum);
		return "redirect:/";
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
