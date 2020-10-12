package com.example.WebProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.domain.dao.TestDAO;
import com.example.WebProject.domain.dto.TestDTO;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDAO testDAO;
	
	@Override
	public List<TestDTO> selectUsers(TestDTO testDTO) throws Exception {
		return testDAO.selectUsers(testDTO);
	}
	
	@Override
	public List<TestDTO> testList() throws Exception {
		return testDAO.testList();
	}
	
	@Override
	public void write(TestDTO testDTO) throws Exception {
		testDAO.insertList(testDTO);
	}
	
	@Override
	public void modify(TestDTO testDTO) throws Exception {
		testDAO.updateList(testDTO);
	}
	
	@Override
	public void remove(int listNum) throws Exception {
		testDAO.deleteList(listNum);
	}
}
