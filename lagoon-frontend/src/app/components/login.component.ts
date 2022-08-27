import { Component } from '@angular/core';
import { tap } from 'rxjs';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
})
export class Login {
  public model = { username: '', password: '' };
  public currentUserName;

  constructor(public loginService: LoginService) {
    this.currentUserName = localStorage.getItem('currentUserName');
  }

  onSubmit() {
    this.loginService.sendCredential(this.model).subscribe({
      next: (data:any) => {    
        localStorage.setItem('token', JSON.parse(JSON.stringify(data)).token);
        this.loginService
          .sendToken(localStorage.getItem('token') || 'me')
          .subscribe({
            next: (data) => {
              this.currentUserName = this.model.username;
              localStorage.setItem('currentUserName', this.model.username);
              this.model.username = '';
              this.model.password = '';
            },
            error: (error) => console.log(error),
          });
      },
      error: (error) => console.log(error),
    });
  }
}
