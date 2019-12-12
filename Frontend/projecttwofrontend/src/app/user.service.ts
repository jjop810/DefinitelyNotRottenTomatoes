import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import { User } from './user';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //private user: User;
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

  public getFake(){

  }
  // public getUser(username: string, password: string): Observable<User>{

  // }

}
