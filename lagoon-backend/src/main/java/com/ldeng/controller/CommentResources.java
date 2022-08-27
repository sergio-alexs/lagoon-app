package com.ldeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldeng.dto.CommentDto;
import com.ldeng.model.Comment;
import com.ldeng.model.Photo;
import com.ldeng.service.CommentService;
import com.ldeng.service.PhotoService;

@RestController
@RequestMapping("rest")
public class CommentResources {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private CommentService commentService;

	@PostMapping("comment/add")
	public void addComment(@RequestBody CommentDto commentDto) {
		Photo photo = photoService.findByPhotoId(commentDto.getPhotoId());
		Comment comment = Comment.builder().commentId(commentDto.getCommentId()).photo(photo)
				.userName(commentDto.getUserName()).content(commentDto.getContent()).photoId(photo.getPhotoId())
				.build();
		commentService.save(comment);
	}

}
