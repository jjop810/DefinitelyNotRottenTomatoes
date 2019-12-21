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

  @Input() rev: Review;

  idy: number;
  reviewy: string;
  revs: Review[] = [];
  //mrevs: Review[];

  constructor(private reviewService: ReviewService, private movieService: MoviesService, private loginService: LoginService, private routeTo: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.rev = new Review();
    this.mov = new Movies();
    this.usr = this.loginService.getUser();


    (<HTMLInputElement>document.getElementById("review_input")).disabled = true;


    this.movieService.getMovieById(this.route.snapshot.params['id']).subscribe(
      movie => {
        // set current movie to the movie retrieved.
        this.mov = movie;
      }
    );

    this.idy = this.mov.id;

    this.reviewService.getMovieReviewByUserId(this.usr.id).subscribe(
      reviews => {
        this.revs = reviews;

        for (let i = 0; i < this.revs.length; i++) {
          if (this.revs[i].movie.id === this.mov.id) {
            this.reviewy = this.revs[i].review;
            (<HTMLInputElement>document.getElementById("review_input")).value = this.reviewy;
          }
          //console.log(i+" "+this.revs[i].id + " movid: "+ this.revs[i].movie.id);
        }
      }
    );




    (<HTMLInputElement>document.getElementById("review_input")).disabled = false;

    (<HTMLInputElement>document.getElementById("id")).value = "" + this.idy;
    (<HTMLInputElement>document.getElementById("user_doc")).value = this.usr.id.toString();;
    


  }

  addMovieRevieworUpdate() {
    this.rev.user = this.usr;
    this.rev.movie = this.mov;

    this.reviewService.CheckReview(this.rev).subscribe(
      resp => { this.created.emit(true) }
    );
    (<HTMLInputElement>document.getElementById("submit")).disabled = true;
    this.routeTo.navigateByUrl('home');
  }

}
