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

	public List<UserDto> listForBeanPropertyRowMapper() {
		String query = "SELECT * FROM user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<UserDto>(UserDto.class));
	}

	public int insert(UserDto user) {
		String query = "INSERT INTO user(userNum, userName) VALUES(?,?)";
		return jdbcTemplate.update(query, user.getUserNum(), user.getUserName());
	}

	public void delete(int userNum) {
		String query = "DELETE FROM user WHERE userNum=?";
		jdbcTemplate.update(query, userNum);
	}
	
	public int update(UserDto user) {
		String query = "UPDATE user SET userName=? where userNum=?";
		return jdbcTemplate.update(query, user.getUserName(), user.getUserNum());
	}

}
