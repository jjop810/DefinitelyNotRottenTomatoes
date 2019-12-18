import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Genre } from './genre';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })


export class GenreService {

    private headers = new HttpHeaders({'Content-Type': 'application/json'});
    constructor( private http: HttpClient) { }
  
    public getGenres(): Observable<Genre[]> {
      return this.http.get('http://localhost:8080/DefinitelyNotRottenTomatoes/genre', {withCredentials: true}).pipe(
        map( resp => resp as Genre[] )
      );
    }
    public getGenre(name: string): Observable<Genre> {
      const url = 'http://localhost:8080/DefinitelyNotRottenTomatoes/genre/' +name;
      return this.http.get(url, {withCredentials: true}).pipe(
        map( resp => resp as Genre )
      );
    }
}
