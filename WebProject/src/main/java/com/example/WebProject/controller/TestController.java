package com.example.WebProject.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebProject.domain.ListDto;
import com.example.WebProject.domain.dao.TestDAO;
import com.example.WebProject.domain.dto.TestDTO;
import com.example.WebProject.service.TestService;

@MapperScan(basePackages = "com.example.WebProject.domain.dao")
@Controller
public class TestController {
	@Autowired
	private TestService testService;

	@Autowired
	SqlSession sqlSession;

	// JSON 데이터로 리스트 나열
	@RequestMapping("/users")
	public List<TestDTO> uesrs(@RequestParam(value = "listName", defaultValue = "") String listName) throws Exception {
		final TestDTO testDTO = null;
		final List<TestDTO> userList = testService.selectUsers(testDTO);
		return userList;
	}

	@RequestMapping("/test")
	public List<TestDTO> loginform() throws Exception {
		List<TestDTO> dto = testService.testList();
		return dto;
	}

	@PostMapping("/add")
	public String insertList(TestDTO testDTO) throws Exception {
		testService.write(testDTO);
		System.out.println(testDTO.getListName());
		
		return "redirect:/index2";
	}

	@PostMapping("/update")
	public String updateList(TestDTO testDTO) throws Exception {
		System.out.print(testDTO);
		testService.modify(testDTO);
		
		return "redirect:/index2";
	}

	@GetMapping("/delete")
	public String deleteList(int listNum) throws Exception {
		System.out.print(listNum);
		testService.remove(listNum);
		
		return "redirect:/index2";
	}

}
