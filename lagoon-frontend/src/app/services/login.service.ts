import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  token!: string;

  constructor(private http: HttpClient) {}

  sendCredential(model: any) {
    let tokenUrl1 = 'http://localhost:8080/user/login';
    let headers1 = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<string>(tokenUrl1, JSON.stringify(model), {
      headers: headers1,
    });
  }

  sendToken(token: string) {
    let tokenUrl2 = 'http://localhost:8080/rest/user/users';
    console.log('Bearer ' + token);

    let getHeaders = new HttpHeaders({ Authorization: 'Bearer ' + token });

    return this.http.get(tokenUrl2, { headers: getHeaders });
  }

  logout() {
    localStorage.setItem('token', '');
    localStorage.setItem('currentUserName', '');
    alert('You just logged out.');
  }

  checkLogin() {
    if (
      localStorage.getItem('currentUserName') != null &&
      localStorage.getItem('currentUserName') != '' &&
      localStorage.getItem('token') != null &&
      localStorage.getItem('token') != ''
    ) {
      return true;
    } else {
      return false;
    }
  }
}
