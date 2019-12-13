import { Injectable } from '@angular/core';
import { Movies } from './movies';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })

export class MoviesService {
//I DON'T KNOW WHAT TO PUT FOR THE HTTP URLs
    private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor( private http: HttpClient) { }

  public getMovies(): Observable<Movies[]> {
    return this.http.get('http://localhost:8080/DefinetlyNotRottenTomatos/movies', {withCredentials: true}).pipe(
      map( resp => resp as Movies[] )
    );
  }
  public getMovie(title: string): Observable<Movies> {
    const url = 'http://localhost:8080/DefinetlyNotRottenTomatos/movies' +title;
    return this.http.get(url, {withCredentials: true}).pipe(
      map( resp => resp as Movies )
    );
  }
  public addMovie(movie: Movies) {
    const body = JSON.stringify(movie);
    return this.http.post('http://localhost:8080/DefinetlyNotRottenTomatos/movies',
      body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as Movies )
    );
  }
  public updateMovie(movie: Movies): Observable<Movies> {
    const url = 'http://localhost:8080/DefinetlyNotRottenTomatos/movies' + movie.id;
    const body = JSON.stringify(movie);
    return this.http.put(url, body, {headers: this.headers, withCredentials: true} ).pipe(
      map( resp => resp as Movies )
    );
  }
 
}
