import { Component } from '@angular/core';
import { Photo } from '../models/photo';
import { UploadPhotoService } from '../services/upload-photo.service';
import { AddPhotoService } from '../services/add-photo.service';
import { UserService } from '../services/user.service';
import { User } from '../models/user';

@Component({
  selector: 'add-photo',
  templateUrl: './add-photo.component.html',
})
export class AddPhoto {
  newPhoto: Photo = new Photo();
  photoAdded: boolean = false;
  user!: User;

  constructor(
    public uploadPhotoService: UploadPhotoService,
    private addPhotoService: AddPhotoService,
    private userService: UserService
  ) {}

  onSubmit() {
    this.userService
      .getUserByName('' + localStorage.getItem('currentUserName'))
      .subscribe({
        next: (user) => {
          this.user = JSON.parse(JSON.stringify(user));
          console.log(this.user);
          this.newPhoto.user = this.user;
          this.addPhotoService.sendPhoto(this.newPhoto).subscribe({
            next: (data) => {
              this.photoAdded = true;
              this.newPhoto = new Photo();
            },
            error: (error) => console.log(error),
          });
        },
        error: (error) => console.log(error),
      });
  }
}
