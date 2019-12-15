import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Watchlist } from './watchlist';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WatchlistService {
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

  constructor( private http: HttpClient) { }

  addWatchlist(userId: number, movieId: number): Observable<Watchlist>  {
    const body = `user=${userId}&movie=${movieId}`;
    console.log('Adding to watchlist: ' + body);
    // return this.http.post('http://localhost:8080/DefinetlyNotRottenTomatos/watchlist', body, {
    //   headers: this.headers, withCredentials: true
    // }).pipe(
    //   map (resp => {
    //     const watch: Watchlist = resp as
    //   }
  };
}
