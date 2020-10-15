/*
 * package com.example.WebProject.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.WebProject.config.ListRepository; import
 * com.example.WebProject.domain.dao.TestDAO; import
 * com.example.WebProject.domain.dto.TestDTO;
 * 
 * @RestController public class TestListController {
 * 
 * @Autowired private ListRepository listReposiotry;
 * 
 * @GetMapping("/save") public String index() throws Exception { TestDTO testDTO
 * = new TestDTO(); testDTO.setListNum(30); testDTO.setListName("김이박");
 * 
 * System.out.println("저장 코드 시작"); listReposiotry.save(testDTO);
 * System.out.println("저장 코드 끝"); return "member 변경!"; } }
 */