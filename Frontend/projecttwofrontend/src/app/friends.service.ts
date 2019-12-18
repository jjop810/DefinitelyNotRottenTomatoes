import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './user';
import { UrlService } from 'src/app/url.service';
@Injectable({
  providedIn: 'root'
})
export class FriendsService {
  private appUrl = this.urlService.getUrl() + '/friends';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }
  getFriends(): Observable<User[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as User[]
      ));
  }
  getFriend(id: number): Observable<User> {
    return this.http.get(this.appUrl + '/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as User
      ));
  }
  public addFriend(user: User) {
    const body = JSON.stringify(user);  // what is the endpoint?
    return this.http.post('http://localhost:8080/DefinetlyNotRottenTomatos/friends',
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as User )
    );
  }

  updateFriend(friends: User): Observable<User> {
    const body = JSON.stringify(friends);
    if (!friends.id) {
      // If there is not id on the friend, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as User )
      );
    } else {
      // If there is an id, we are...
      // updating an existing resource
      const url = this.appUrl + '/' + friends.id;
      return this.http.put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as User
      ));
    }
  }
}
