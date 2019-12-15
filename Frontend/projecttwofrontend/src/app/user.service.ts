import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import { User } from './user';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor( private http: HttpClient) { }


  public getUsers(): Observable<User[]> {
    return this.http.get('http://localhost:8080/DefinetlyNotRottenTomatos/login', {withCredentials: true}).pipe(
      map( resp => resp as User[] )
    );
  }


  public getUserById(id: number): Observable<User>{
    const url = 'http://localhost:8080/DefinetlyNotRottenTomatos/login' + id;
    return this.http.get(url,{withCredentials: true}).pipe(
      map(resp => resp as User)
    );
  }

  public addUser(user: User) {
    const body = JSON.stringify(user);
    return this.http.post('http://localhost:8080/DefinetlyNotRottenTomatos/login',
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as User )
    );
  }
}
