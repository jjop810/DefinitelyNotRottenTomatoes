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
    console.log(watchlist);
    const body = JSON.stringify(watchlist);
    return this.http.post(this.appUrl + '/watchlist', body, {
       headers: this.headers, withCredentials: true
     }).pipe(
       map (resp => resp as Watchlist  )
     );
    }
  }

  getMovies(user: User, page: number): Observable<Movies[]> {
    const body = user.id + ',' + user.username + ',' + page;
    console.log('Getting watchlist from: ' + this.appUrl + '/getwatchlist/' + body);
    return this.http.get(this.appUrl + '/getwatchlist/' + body, { withCredentials: true } ).pipe(
      map( resp => resp as Movies[])
    );
  }

  getLastPage(): Observable<number> {
    return this.http.get(this.appUrl + '/getwatchlist', {withCredentials: true} ).pipe(
      map( resp => resp as number)
    );
  }

  getMovieSearch(searchTxt: string, pageNum: number): Observable<Movies[]> {
    if (searchTxt && pageNum && !isNaN(pageNum)) {
      const body = searchTxt + '|' + pageNum;
      console.log(body);
      return this.http.get(this.appUrl + '/watchlist/' + body, {headers: this.headers, withCredentials: true}).pipe(
        map( resp => resp as Movies[])
        );
    }
  }
}
