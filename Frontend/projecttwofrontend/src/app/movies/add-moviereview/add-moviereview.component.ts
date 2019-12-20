import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { ReviewService } from 'src/app/all-shared/review-shared/review.service';
import { MoviesService } from '../shared/movies.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Movies } from '../shared/movies';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { LoginService } from 'src/app/login.service';
import { Review } from 'src/app/all-shared/review-shared/review';

@Component({
  selector: 'app-add-moviereview',
  templateUrl: './add-moviereview.component.html',
  styleUrls: ['./add-moviereview.component.css']
})
export class AddMoviereviewComponent implements OnInit {

  @Output() created = new EventEmitter<Boolean>();
  @Input() mov: Movies;
  @Input() usr: User;

  @Input() rev:Review;

  idy: number;
  reviewy: string;

  constructor(private reviewService: ReviewService, private movieService: MoviesService, private loginService:LoginService, private routeTo: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.rev = new Review();
    this.mov = new Movies();
    this.usr = this.loginService.getUser();
    //this.mov = this.getMovie("MovieTesty");

    this.movieService.getMovieById(this.route.snapshot.params['id']).subscribe(
      movie => {
        // set current movie to the movie retrieved.
        this.mov = movie;
      }
    );

      this.idy = this.mov.id;
      
      
      (<HTMLInputElement>document.getElementById("id")).value = "" + this.idy;
      (<HTMLInputElement>document.getElementById("user_doc")).value =  this.usr.id;


  }

  addMovieRevieworUpdate(){
    this.rev.user = this.usr;
    this.rev.movie = this.mov;

    this.reviewService.CheckReview(this.rev).subscribe(
      resp => {this.created.emit(true)}
    );
    
  }

}
