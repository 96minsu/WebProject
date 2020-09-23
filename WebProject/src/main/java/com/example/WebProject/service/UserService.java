package com.example.WebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.WebProject.domain.UserDao;
import com.example.WebProject.domain.UserDto;

@Service
@Transactional
public class UserService {
	
	public static final int ID_AND_PASSWD_OK=1;
	public static final int ONLY_PASSWD_FAIL=0;
	public static final int ID_AND_PASSWD_FAIL=-1;
	
	@Autowired
	private UserDao userDao;
	
	public int userCheck(String id, String password) {
		UserDto userDto = userDao.get(id);
		if (userDto != null) {
			if (userDto.getPassword().equals(password)) {
				return ID_AND_PASSWD_OK;
			} else {
				return ONLY_PASSWD_FAIL;
			}
		} else {
			return ID_AND_PASSWD_FAIL;
		}
	}
	
	
}
