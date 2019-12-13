import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Movies } from './movies';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  private appUrl = this.url.getUrl() + '/movies/';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private url: UrlService, private http: HttpClient) { }

  getMovies(page: number): Observable<Movies[]> {
    return this.http.get(this.appUrl + page, {withCredentials: true} ).pipe(
      map( resp => resp as Movies[])
    );
  }

  getLastPage(): Observable<number> {
    return this.http.get(this.appUrl, {withCredentials: true} ).pipe(
      map( resp => resp as number)
    );
  }

}
