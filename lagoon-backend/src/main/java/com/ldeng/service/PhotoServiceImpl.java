package com.ldeng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ldeng.dao.PhotoDao;
import com.ldeng.model.Photo;
import com.ldeng.model.User;

@Service
public class PhotoServiceImpl implements PhotoService {

	private PhotoDao photoDao;

	@Autowired
	public PhotoServiceImpl(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	@Override
	public Photo save(Photo photo) {
		return photoDao.save(photo);
	}

	@Override
	public List<Photo> findAll() {
		return Lists.newArrayList(photoDao.findAll());
	}

	@Override
	public List<Photo> findByUser(User user) {
		return photoDao.findByUser(user);
	}

	@Override
	public Photo findByPhotoId(Long photoId) {
		return photoDao.findById(photoId).orElse(null);
	}
}
