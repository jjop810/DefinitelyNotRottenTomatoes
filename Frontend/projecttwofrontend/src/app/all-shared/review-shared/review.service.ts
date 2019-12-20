import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { Observable } from 'rxjs';
import { Review } from './review';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })

export class ReviewService {
    private smth: Review;
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    private uri = 'http://localhost:8080/DefinitelyNotRottenTomatoes/review/';
  
    constructor(private http: HttpClient) { }
  
    public getReviews(): Observable<Review[]>{
      return this.http.get(this.uri, {withCredentials: true}).pipe(
        map(resp => resp as Review[])
      );
  
    }
  
    public getReviewById(id: number): Observable<Review>{
      const url = this.uri + id;
  
      return this.http.get(url,{withCredentials: true}).pipe(
        map(resp => resp as Review)
      );
  
    }
  
    public CheckReview(m: Review): Observable<Review>{
      const body = JSON.stringify(m);
      
      // tslint:disable-next-line: max-line-length
      return this.http.post(this.uri +'moviereview' , body, {headers: this.headers, withCredentials: true}).pipe(
        map(resp => resp as Review)
      );
    }
    
  
  
    public addReview(reviews: Review){
      const body = JSON.stringify(reviews);
      // tslint:disable-next-line: max-line-length
      return this.http.post(this.uri, body, {headers: this.headers, withCredentials: true}).pipe(
        map(resp => resp as Review)
      );
    }
  
    public updateReview(review: Review): Observable<Review>{
      const url = this.uri + review.id;
      const body = JSON.stringify(review);
      return this.http.put(url, body, {headers:this.headers, withCredentials: true}).pipe(
        map(resp => resp as Review)
      );
  
    }
  
    public deleteReview(review: Review): Observable<void>{
    const url = this.uri + review.id;
    const body = JSON.stringify(review);
    return this.http.delete(url,{headers: this.headers, withCredentials: true}).pipe(
      map (resp => null)
    );
    }
}
