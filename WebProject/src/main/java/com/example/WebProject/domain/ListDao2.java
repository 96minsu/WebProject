
package com.example.WebProject.domain;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.example.WebProject.pNs.Pagination;
import com.example.WebProject.pNs.Search;

public interface ListDao2 {
	
	public int getTotalCount();

	public int getListCount();

	public List<ListDto> listForBeanPropertyRowMapper() ;

	public int insert(ListDto list);

	public void delete(int listNum);
	
	public int update(ListDto list);

	public void selectNum(int listNum) throws Exception;

	public int getBoardListCnt(Search search) throws Exception;

	public List<ListDto> getBoardList(Search search) throws Exception;

}
