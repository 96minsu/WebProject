
package com.example.WebProject.domain;

import java.util.List;

import com.example.WebProject.pNs.Pagination;
import com.example.WebProject.pNs.Search;

public interface ListDaoInterface {
	public int getBoardListCnt(Search search) throws Exception;

	public List<ListDto> getBoardList(Search search) throws Exception;

}
