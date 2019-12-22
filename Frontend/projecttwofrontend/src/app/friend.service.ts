import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './shared/url.service';
import { Friend } from './friend';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class FriendService {
  private appUrl = this.urlService.getUrl() + '/friends';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient, private urlService: UrlService) { }
  public getFriends(): Observable<Friend[]> {
    return this.http.get(this.appUrl, {withCredentials: true}).pipe(
      map( resp => resp as Friend[] )
    );
  }
/*
  public deleteFriend(user: User): void {
    const body = JSON.stringify(user);
    return this.http.delete(this.appUrl, {withCredentials: true} ).pipe(
      map( resp => resp as User )
    );
  }*/

  public addFriend(friend: Friend) {
    const body = JSON.stringify(friend);
    return this.http.post(this.appUrl,
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as Friend )
    );
  }

  
}
