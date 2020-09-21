package com.example.WebProject.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int countById(String id) {
		String query = "SELECT COUNT(*) FROM user WHERE id = ?";
		int count = jdbcTemplate.queryForObject(query, Integer.class, id);
		return count;
	}
	
	public UserDto get(String id) {
		try {
			UserDto m = jdbcTemplate.queryForObject("SELECT * FROM user WHERE id=?",
					new BeanPropertyRowMapper<UserDto>(UserDto.class), id);
			return m;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
