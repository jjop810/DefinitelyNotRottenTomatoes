import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from './admin';
import { User } from './user';
import { Currentuser } from './currentuser';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
  private admin: Admin;
  private user: User;
  constructor( private http: HttpClient) { }

  login(username: string, password: string): Observable<Currentuser>{
    if (username && password) {
      const body = `user=${username}&pass=${password}`;
      //const body = JSON.stringify([username, password]);
      console.log(body);

      return this.http.post('http://localhost:8080/DefinetlyNotRottenTomatos/logined', body, {
        headers: this.headers, withCredentials: true
      }).pipe(
        map (resp => {
          const u: Currentuser = resp as Currentuser;
          if (u) {
            this.admin = u.admin;
            this.user = u.user;
            
          }
          return u;

        })
      );
    } else{
      return this.http.get('http://localhost:8080/DefinetlyNotRottenTomatos/logined').pipe(
        map( resp => {
          const u: Currentuser = resp as Currentuser;
          if (u) {
            this.admin = u.admin;
            this.user = u.user;
          }
          return u;
        })
      );
    }
  }

  logout(): Observable<object>{
    return this.http.delete('http://localhost:8080/DefinetlyNotRottenTomatos/logined',{withCredentials:true}).pipe(
      map(success => {
        this.admin = null;
        this.user = null;
        return success;
      })
    );
  }

  getUser(): User{
    return this.user;
  }

  getAdmin(): Admin{
    return this.admin;

  }

  isAdmin(): boolean{
    return (this.admin !== undefined && this.admin !==null);
  }
  isUser(): boolean{
    return (this.user !== undefined && this.user !== null);
  }

}
