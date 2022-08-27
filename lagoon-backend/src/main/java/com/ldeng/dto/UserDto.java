package com.ldeng.dto;

import java.util.Date;
import java.util.List;

import com.ldeng.model.Photo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private Long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Date created;
	private List<Photo> photoList;
	private List<Photo> likedPhotoList;
}
