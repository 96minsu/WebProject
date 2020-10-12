package com.example.WebProject.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.WebProject.domain.dto.TestDTO;

@Mapper
public interface TestDAO {
	
	List<TestDTO> selectUsers(TestDTO testDTO) throws Exception;
	
	public List<TestDTO> testList() throws Exception;
	
	public void insertList(TestDTO testDTO) throws Exception;
	
	public void deleteList(int num) throws Exception;
	
	public void updateList(TestDTO testDTO) throws Exception;
}
