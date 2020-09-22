package com.example.WebProject.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ListDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getTotalCount()
	{
		String query = "select count(*) from user";
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
		return jdbcTemplate.update(query, list.getListName(), list.getListNum());
	}
	
	public int select(ListDto list) {
		String query = "SELECT ? from list WHERE listNum=?";
		return jdbcTemplate.update(query, list.getListName(), list.getListNum());
	}

}
