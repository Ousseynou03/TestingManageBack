import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8090/user';

  constructor(private http: HttpClient) { }

  signUp(user: User, headers: any) {
    const url = `${this.baseUrl}/signup`;
    return this.http.post(url, user, { headers });
  }



  login(credentials: { email: string, password: string }) {
    return this.http.post(`${this.baseUrl}/login`, credentials);
  }
  
}
