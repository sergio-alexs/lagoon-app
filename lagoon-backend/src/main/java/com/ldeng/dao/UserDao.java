package com.ldeng.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ldeng.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	User findByUserName(String userName);

}
