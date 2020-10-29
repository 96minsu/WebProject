package com.example.WebProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.domain.dao.TestDAO;
import com.example.WebProject.domain.dto.FileVO;
import com.example.WebProject.domain.dto.TestDTO;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDAO testDAO;
	
	public TestServiceImpl( ) {
		setNameSpace("com.example.WebProject.domain.dao.TestDAO");
	}
	
	private void setNameSpace(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestDTO> selectUsers(TestDTO testDTO) throws Exception {
		return testDAO.selectUsers(testDTO);
	}
	
	@Override
	public List<TestDTO> testList() throws Exception {
		return testDAO.testList();
	}
	
	@Override
	public List<TestDTO> testAllList() throws Exception {
		return testDAO.testAllList();
	}
	
	@Override
	public TestDTO listDetailService(int listNum) throws Exception {
		return testDAO.listDetail(listNum);
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
	
	@Override
	public int insertFileService(FileVO file) throws Exception {
		return testDAO.insertFile(file);
	}
	
	@Override
	public FileVO fileDetailService(int listNum) throws Exception{
		return testDAO.fileDetail(listNum);
	}
	
	@Override
	public List<TestDTO> regdate() throws Exception{
		return testDAO.regdate();
	}
	
	/*
	 * @Override public int insertFileService2(TestDTO file) throws Exception {
	 * return testDAO.insertFile2(file); }
	 * 
	 * @Override public TestDTO fileDetailService2(int listNum) throws Exception{
	 * return testDAO.fileDetail2(listNum); }
	 */
}
