import { Component, OnInit, Input } from '@angular/core';
import { ReviewService } from '../review.service';
import { MoviesService } from 'src/app/movies/shared/movies.service';
import {  ActivatedRoute } from '@angular/router';
import { Movies } from 'src/app/movies/shared/movies';
import { Review } from '../review';
import { User } from 'src/app/user';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-show-guest-review',
  templateUrl: './show-guest-review.component.html',
  styleUrls: ['./show-guest-review.component.css']
})
export class ShowGuestReviewComponent implements OnInit {

  public mov: Movies;
  public reviews: Review[];

  public user: User;
  public review: Review;

  constructor(private reviewService: ReviewService, private movieService: MoviesService, private loginService: LoginService,
      private route: ActivatedRoute) { }

  ngOnInit() {
    this.mov = new Movies();
    this.user = new User();
    this.reviews = [];

    

    this.movieService.getMovieById(this.route.snapshot.params['id']).subscribe(
      movie => {
        // set current movie to the movie retrieved.
        this.mov = movie;
        console.log(this.mov.id);
        this.reviewService.getMovieReviewByMovieId(this.mov.id).subscribe(
          reviews =>{
            this.reviews = reviews;
          }
        );
      }
    );
    
      this.review = new Review();

  }

}
