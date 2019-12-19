import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Watchlist } from './watchlist';
import { map } from 'rxjs/operators';
import { UrlService } from 'src/app/shared/url.service';
import { Movies } from './movies/shared/movies';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class WatchlistService {
  watchlist: Watchlist[];
  private appUrl = this.url.getUrl();
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient, private url: UrlService) { }

  addWatchlist(watchlist: Watchlist): Observable<Watchlist>  {
    if (watchlist) {
    const body = JSON.stringify(watchlist);
    console.log('Adding to watchlist: ' + body);
    return this.http.post(this.appUrl + '/watchlist', body, {
       headers: this.headers, withCredentials: true
     }).pipe(
       map (resp => resp as Watchlist  )
     );
    }
  }

  getMovies(user: User): Observable<Movies[]> {
    return this.http.post(this.appUrl + '/getwatchlist', user, { headers: this.headers, withCredentials: true } ).pipe(
      map( resp => resp as Movies[])
    );
  }
}
