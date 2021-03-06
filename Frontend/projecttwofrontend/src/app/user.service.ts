import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { map, catchError } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class UserService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor( private http: HttpClient) { }


  public getUsers(): Observable<User[]> {
    return this.http.get('http://localhost:8080/DefinitelyNotRottenTomatoes/login', {withCredentials: true}).pipe(
      map( resp => resp as User[] )
    );
  }


  public getUserById(id: number): Observable<User>{
    const url = 'http://localhost:8080/DefinetlyNotRottenTomatos/login/' + id;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp => resp as User)
    );
  }
  public getUserByUsername(name: string): Observable<User> {
    const url = 'http://localhost:8080/DefinitelyNotRottenTomatoes/friends/' + name;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp => resp as User)
    );
  }

  public addUser(user: User) {
    const body = JSON.stringify(user);
    return this.http.post('http://localhost:8080/DefinitelyNotRottenTomatoes/login',
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as User )
    );
  }
  public editUser(user: User) {
    const body = JSON.stringify(user);
    return this.http.put('http://localhost:8080/DefinitelyNotRottenTomatoes/login/' + user.id,
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as User )
    );
  }

}
