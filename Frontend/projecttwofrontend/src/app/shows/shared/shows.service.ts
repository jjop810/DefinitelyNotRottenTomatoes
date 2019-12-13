import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Shows } from './shows';
import { map } from 'rxjs/operators';



@Injectable({
    providedIn: 'root'
  })

export class ShowsService {

    private headers = new HttpHeaders({'Content-Type': 'application/json'});
    constructor( private http: HttpClient) { }
  
    public getShows(): Observable<Shows[]> {
      return this.http.get('http://localhost:8080/DefinetlyNotRottenTomatos/shows', {withCredentials: true}).pipe(
        map( resp => resp as Shows[] )
      );
    }
    public getShow(title: string): Observable<Shows> {
      const url = 'http://localhost:8080/DefinetlyNotRottenTomatos/shows' +title;
      return this.http.get(url, {withCredentials: true}).pipe(
        map( resp => resp as Shows )
      );
    }
    public addShow(show: Shows) {
      console.log("this is the passed in variable:"+show);
      const body = JSON.stringify(show);
      console.log("this is the body:"+body);
      return this.http.post('http://localhost:8080/DefinetlyNotRottenTomatos/shows',
        body, {headers: this.headers, withCredentials: true} ).pipe(
        map( resp => resp as Shows )
      );
    }
    public updateShow(show: Shows): Observable<Shows> {
      const url = 'http://localhost:8080/DefinetlyNotRottenTomatos/shows' + show.id;
      const body = JSON.stringify(show);
      return this.http.put(url, body, {headers: this.headers, withCredentials: true} ).pipe(
        map( resp => resp as Shows )
      );
    }
}
