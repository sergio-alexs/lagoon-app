package com.ldeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldeng.model.User;
import com.ldeng.service.UserService;

@RestController
@RequestMapping("rest")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("user/users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PostMapping(value = "user/userName")
	public User findByUserName(@RequestBody String userName) {
		return userService.findByUserName(userName);
	}

	@PostMapping(value = "user/update")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}

}
