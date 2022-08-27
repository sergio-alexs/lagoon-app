package com.ldeng.dto;

import com.ldeng.model.Photo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private Long commentId;
	private String content;
	private Photo photo;
	private Long photoId;
	private String userName;
}
