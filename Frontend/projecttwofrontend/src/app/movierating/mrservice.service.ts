import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movierating } from './movierating';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MrserviceService {

  private smth: Movierating;
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  /*All the movie ratings that are there*/
  public getMovieRating(): Observable<Movierating[]>{
    return this.http.get('http://localhost:8080/DefinitelyNotRottenTomatoes/movierating', {withCredentials: true}).pipe(
      map(resp => resp as Movierating[])
    );

  }
  /*Movie rating list for a user*/
  public getMovieRatingByUserId(uid: number): Observable<Movierating[]>{
    const url = 'http://localhost:8080/DefinitelyNotRottenTomatoes/movierating/' + uid;

    return this.http.get(url,{withCredentials: true}).pipe(
      map(resp => resp as Movierating[])
    );

  }

  /*Movie rating list for a movieid*/
  public getMovieRatingByMovieId(mid: number): Observable<Movierating[]>{
    const url = 'http://localhost:8080/DefinitelyNotRottenTomatoes/movierating/movies/ratings/' + mid;

    return this.http.get(url,{withCredentials: true}).pipe(
      map(resp => resp as Movierating[])
    );

  }

  /*Updating or Adding the movie ratings*/
  public CheckMovieRating(m: Movierating): Observable<Movierating>{
    const body = JSON.stringify(m);
    // tslint:disable-next-line: max-line-length
    return this.http.post('http://localhost:8080/DefinitelyNotRottenTomatoes/movierating/add' , body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => resp as Movierating)
    );
  }

  /*Just adding the movie ratings*/
  public addMovieRating(movierating: Movierating){
    const body = JSON.stringify(movierating);
    // tslint:disable-next-line: max-line-length
    return this.http.post('http://localhost:8080/DefinitelyNotRottenTomatoes/movierating/', body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => resp as Movierating)
    );
  }

  /*Just updating the movie ratings*/
  public updateMovieRating(movierating: Movierating): Observable<Movierating>{
    const url = 'http://localhost:8080/DefinitelyNotRottenTomatoes/movierating/' + movierating.id;
    const body = JSON.stringify(movierating);
    return this.http.put(url, body, {headers:this.headers, withCredentials: true}).pipe(
      map(resp => resp as Movierating)
    );

  }

  public deleteMovieRating(movierating: Movierating): Observable<void>{
  const url = 'http://localhost:8080/DefinitelyNotRottenTomatoes/movierating/' + movierating.id;
  const body = JSON.stringify(movierating);
  return this.http.delete(url,{headers: this.headers, withCredentials: true}).pipe(
    map (resp => null)
  );


  }



}
