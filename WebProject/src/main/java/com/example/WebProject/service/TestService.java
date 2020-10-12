package com.example.WebProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;

import com.example.WebProject.domain.dto.TestDTO;

public interface TestService {
	
	List<TestDTO> selectUsers(TestDTO testDTO) throws Exception;
	
	public List<TestDTO> testList() throws Exception;
	
	public void write(TestDTO dto) throws Exception;
	
	public void modify(TestDTO dto) throws Exception;
	
	public void remove(int num) throws Exception;
	
}
