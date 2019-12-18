import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Movies } from '../movies/shared/movies';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private appUrl = this.url.getUrl() + '/movies/search/';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private url: UrlService, private http: HttpClient) { }

  getMovieSearch(searchTxt: string, pageNum: number): Observable<Movies[]> {
    if (searchTxt && pageNum && !isNaN(pageNum)) {
      const body = searchTxt + '|' + pageNum;
      console.log(body);
      return this.http.get(this.appUrl + body, {headers: this.headers, withCredentials: true}).pipe(
        map( resp => resp as Movies[])
        );
      }
      }
}
