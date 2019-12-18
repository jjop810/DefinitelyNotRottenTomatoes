import { Injectable } from '@angular/core';
import { Movies } from './movies';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { UrlService } from 'src/app/shared/url.service';

@Injectable({
    providedIn: 'root'
  })

export class MoviesService {
  constructor( private http: HttpClient, private url: UrlService) { }
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  private appUrl = this.url.getUrl() + '/movies/';

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

  public getMovie(title: string): Observable<Movies> {
    return this.http.get(this.appUrl + title, {withCredentials: true}).pipe(
      map( resp => resp as Movies )
    );
  }
  public getMovieById(id: number): Observable<Movies> {
    return this.http.get(this.url.getUrl() + '/movies/edit/' + id, {withCredentials: true}).pipe(
      map( resp => resp as Movies )
    );
  }

  public addMovie(movie: Movies) {
    const body = JSON.stringify(movie);
    return this.http.post(this.appUrl,
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as Movies )
    );
  }
  public updateMovie(movie: Movies): Observable<Movies> {
    const url = this.appUrl + movie.id;
    const body = JSON.stringify(movie);
    return this.http.put(url, body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as Movies )
    );
  }
}
