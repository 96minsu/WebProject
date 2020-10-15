package com.example.WebProject.domain;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.WebProject.pNs.Pagination;
import com.example.WebProject.pNs.Search;

@Repository
public class ListDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	public int getTotalCount() {
		String query = "select count(*) from user";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

	public int getListCount() {
		String query = "select count(*) from list";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

	public List<ListDto> listForBeanPropertyRowMapper() {
		String query = "SELECT * FROM list";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<ListDto>(ListDto.class));
	}

	public int insert(ListDto list) {
		String query = "INSERT INTO list(listNum, listName) VALUES(?,?)";
		return jdbcTemplate.update(query, list.getListNum(), list.getListName());
	}

	public void delete(int listNum) {
		String query = "DELETE FROM list WHERE listNum=?";
		jdbcTemplate.update(query, listNum);
	}

	public int update(ListDto list) {
		String query = "UPDATE list SET listName=? where listNum=?";
		System.out.println(jdbcTemplate.update(query, list.getListName(), list.getListNum()));
		return jdbcTemplate.update(query, list.getListName(), list.getListNum());
	}

	public void selectNum(int listNum) {
		String query = "SELECT listNum FROM list WHERE listNum=?";
		jdbcTemplate.update(query, listNum);
	}

	/*
	 * @Override public int getBoardListCnt(Search search) throws Exception { String
	 * query = "select count(*) as listCnt from list"; return
	 * jdbcTemplate.queryForObject(query, Integer.class); }
	 */

	public List<ListDto> getBoardList(Search search) throws Exception {
	  String query = "select listNum, listName from list limit ?, ?";
	  //System.out.println(search.getStartList());
	  //System.out.println(search.getListSize()); return jdbcTemplate.query(query,
	  return  jdbcTemplate.query
			  (query, new BeanPropertyRowMapper<ListDto>(ListDto.class), search.getStartList(), search.getListSize());
	  }

}
