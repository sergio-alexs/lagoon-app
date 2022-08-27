package com.ldeng.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ldeng.model.Photo;
import com.ldeng.model.User;
import com.ldeng.service.PhotoService;

@RestController
@RequestMapping("/rest")
public class PhotoResource {

	private String imageName;

	@Autowired
	private PhotoService photoService;

	@PostMapping(value = "photo/upload")
	public String upload(HttpServletResponse response, HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> it = multipartRequest.getFileNames();
		MultipartFile multipartFile = multipartRequest.getFile(it.next());

		Optional<String> nonEmptyOptional = Optional.ofNullable(multipartFile.getOriginalFilename());

		if (nonEmptyOptional.isPresent()) {
			String fileName = nonEmptyOptional.get();
			imageName = fileName;

			String path = new File("src/main/resources/static/images").getAbsolutePath() + "\\" + fileName;
			try {
				multipartFile.transferTo(new File(path));
				System.out.println(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "Upload Success!";
	}

	@PostMapping(value = "photo/add")
	public Photo addPhoto(@RequestBody Photo photo) {
		photo.setImageName(imageName);
		return photoService.save(photo);
	}

	@PostMapping(value = "photo/user")
	public List<Photo> getPhotosByUser(@RequestBody User user) {
		return photoService.findByUser(user);
	}

	@PostMapping(value = "photo/photoId")
	public Photo getPhotoByPhotoId(@RequestBody Long photoId) {
		return photoService.findByPhotoId(photoId);
	}

	@PostMapping(value = "photo/update")
	public void updatePhoto(@RequestBody Photo photo) {
		Photo currentPhoto = photoService.findByPhotoId(photo.getPhotoId());
		currentPhoto.setLikes(photo.getLikes());
		photoService.save(currentPhoto);
	}
}
