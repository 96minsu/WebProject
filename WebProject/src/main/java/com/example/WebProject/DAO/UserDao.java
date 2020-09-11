package com.example.WebProject.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.WebProject.VO.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> listForBeanPropertyRowMapper() {
		String query = "select * from user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public int insert(User user) {
		String query = "insert into user(userNum, userName) values(?,?)";
		return jdbcTemplate.update(query, user.getUserNum(), user.getUserName());
	}
}
