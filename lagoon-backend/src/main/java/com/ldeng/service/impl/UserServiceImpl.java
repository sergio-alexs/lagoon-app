package com.ldeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ldeng.dao.UserDao;
import com.ldeng.model.User;
import com.ldeng.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllUsers() {
		return Lists.newArrayList(userDao.findAll());
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

}
