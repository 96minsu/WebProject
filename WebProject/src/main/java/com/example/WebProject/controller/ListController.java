package com.example.WebProject.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	
	@PostMapping("/add")
	public String listAdd(ListDto list) {
		System.out.print(list);
		listDao.insert(list);
		return "redirect:/index2";
	}
	
	@PostMapping("/update")
	public String listUpdate(ListDto list) {
		System.out.print(list);
		listDao.update(list);
		return "redirect:/index2";
	}

	@GetMapping("/delete")
	public String listDelete(int listNum) {
		System.out.print(listNum);
		listDao.delete(listNum);
		return "redirect:/index2";
	}
	
	/*
	 * @RequestMapping(value="/index2") public String boardList(HttpServletRequest
	 * req, ModelMap modelMap, @ModelAttribute("boardSearchVO") ListDto listDto) {
	 * String jspPath=req.getRequestURI();
	 * 
	 * // paging : S int pageSize = listDto.getPageSize(); int pageIndex =
	 * listDto.getPageIndex(); int pageGroupSize = listDto.getPageGroupSize(); int
	 * startRow = (pageIndex - 1) * pageSize + 1; int endRow = pageIndex * pageSize;
	 * 
	 * listDto.setStartRow(startRow); listDto.setEndRow(endRow); int count =
	 * listDao.getListCount();
	 * 
	 * int pageGroupCount = count/(pageSize * pageGroupSize) + (count % (pageSize *
	 * pageGroupSize) == 0 ? 0 : 1); int nowPageGroup = (int) Math.ceil((double)
	 * pageIndex / pageGroupSize);
	 * 
	 * List<ListDto> boardList = listDao.listForBeanPropertyRowMapper();
	 * 
	 * modelMap.put("pageIndex", pageIndex); modelMap.put("pageSize", pageSize);
	 * modelMap.put("count", count); modelMap.put("pageGroupSize", pageGroupSize);
	 * modelMap.put("nowPageGroup", nowPageGroup); modelMap.put("pageGroupCount",
	 * pageGroupCount); modelMap.put("articleList", boardList);
	 * modelMap.put("listDto", listDto);
	 * 
	 * return jspPath; }
	 */


}