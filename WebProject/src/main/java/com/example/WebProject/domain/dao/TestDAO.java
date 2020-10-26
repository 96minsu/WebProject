package com.example.WebProject.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.WebProject.domain.dto.FileVO;
import com.example.WebProject.domain.dto.TestDTO;

@Mapper
public interface TestDAO {
	
	List<TestDTO> selectUsers(TestDTO testDTO) throws Exception;
	
	public List<TestDTO> testList() throws Exception;
	
	public List<TestDTO> testAllList() throws Exception;
	
	public TestDTO listDetail(int listNum) throws Exception;
	
	public void insertList(TestDTO testDTO) throws Exception;
	
	public void deleteList(int num) throws Exception;
	
	public void updateList(TestDTO testDTO) throws Exception;
	
	public int insertFile(FileVO file) throws Exception;
	
	public FileVO fileDetail(int listNum) throws Exception;
	
	public int countDate() throws Exception;

	public List<TestDTO> zzz() throws Exception;
	
	public List<TestDTO> regdate() throws Exception;
	/*
	 * public int insertFile2(TestDTO file) throws Exception;
	 * 
	 * public TestDTO fileDetail2(int listNum) throws Exception;
	 */


}
