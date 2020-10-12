
package com.example.WebProject.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.domain.ListDto;
import com.example.WebProject.pNs.Pagination;
import com.example.WebProject.pNs.Search;

@Service
@Transactional
public interface BoardService {
	public int getBoardListCnt(Search search) throws Exception;

	public List<ListDto> getBoardList(Search search) throws Exception;

}
