package com.example.WebProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.domain.ListDao;
import com.example.WebProject.domain.ListDto;
import com.example.WebProject.pNs.Pagination;
import com.example.WebProject.pNs.Search;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	ListDao listDao;
	
	@Override
	public int getBoardListCnt(Search search) throws Exception {

		return listDao.getBoardListCount(search);
	}
	
	@Override
	public List<ListDto> getBoardList(Search search) throws Exception {
		return listDao.getBoardList(search);
	}
}
