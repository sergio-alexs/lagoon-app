package com.ldeng.dto;

import java.util.Date;
import java.util.List;

import com.ldeng.model.Comment;
import com.ldeng.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDto {

	private Long photoId;
	private String photoName;
	private String title;
	private String description;
	private String imageName;
	private Date created;
	private User user;
	private int likes;
	private List<Comment> commentList;
}
