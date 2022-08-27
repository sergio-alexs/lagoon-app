package com.ldeng.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ldeng.model.Photo;
import com.ldeng.model.User;

@Repository
public interface PhotoDao extends CrudRepository<Photo, Long> {

	List<Photo> findByUser(User user);

}
