import { Component, Input } from '@angular/core';
import { Photo } from '../models/photo';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { Comment } from '../models/comment';
import { CommentService } from '../services/comment.service';
import { PhotoService } from '../services/photo.service';

@Component({
  selector: 'image-comments',
  templateUrl: './image-comments.component.html',
})
export class ImageComments {
  @Input('photo') photo!: Photo;
  myLocalStorage = localStorage;
  user: User = new User();
  newComment = new Comment();

  constructor(
    private userService: UserService,
    private commentService: CommentService,
    private photoService: PhotoService
  ) {
    this.userService
      .getUserByName('' + localStorage.getItem('currentUserName'))
      .subscribe({
        next: (user) => {
          this.user = JSON.parse(JSON.stringify(user));
        },
        error: (error) => console.log(error),
      });
  }

  onInit() {}

  onSubmit() {
    console.log(this.photo);
    console.log(this.photo.commentList);
    this.newComment.photo = this.photo;
    this.newComment.userName = this.user.userName;
    this.newComment.photoId = this.photo.photoId;
    this.commentService.addComment(this.newComment).subscribe({
      next: (photo) =>
        this.photoService.getPhotoById(this.photo.photoId).subscribe({
          next: (photo) => (this.photo = JSON.parse(JSON.stringify(photo))),
          error: (error) => console.log(error),
        }),
      error: (error) => console.log(error),
    });
    // this.photo.commentList.push(this.newComment);

    this.newComment = new Comment();
  }
}
