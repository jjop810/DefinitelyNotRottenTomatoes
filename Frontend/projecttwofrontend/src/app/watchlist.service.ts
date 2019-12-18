import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Watchlist } from './watchlist';
import { map } from 'rxjs/operators';
import { UrlService } from 'src/app/shared/url.service';

@Injectable({
  providedIn: 'root'
})
export class WatchlistService {
  watchlist: Watchlist[];
  private appUrl = this.url.getUrl() + '/watchlist';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient, private url: UrlService) { }

  addWatchlist(watchlist: Watchlist): Observable<Watchlist>  {
    if (watchlist) {
    const body = JSON.stringify(watchlist);
    console.log('Adding to watchlist: ' + body);
    return this.http.post('http://localhost:8080/DefinitelyNotRottenTomatoes/watchlist', body, {
       headers: this.headers, withCredentials: true
     }).pipe(
       map (resp => resp as Watchlist  )
     );
    }
    // return this.http.post(this.appUrl,
    //   body, {headers: this.headers, withCredentials: true} ).pipe(
    //   map( resp => resp as Movies )
    // );
  }
}
