package com.ldeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldeng.dao.CommentDao;
import com.ldeng.model.Comment;
import com.ldeng.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public Comment save(Comment comment) {
		return commentDao.save(comment);
	}

	@Override
	public Comment findOne(Long commentId) {
		return commentDao.findById(commentId).orElse(null);
	}

	@Override
	public List<Comment> findByPhotoId(Long photoId) {
		return commentDao.findByPhotoId(photoId);
	}

}
