import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/all-shared/review-shared/review';
import { User } from 'src/app/user';
import { ReviewService } from 'src/app/all-shared/review-shared/review.service';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-user-review-list',
  templateUrl: './user-review-list.component.html',
  styleUrls: ['./user-review-list.component.css']
})
export class UserReviewListComponent implements OnInit {
  
  reviews: Review[];
  review: Review;
  user: User;
  
  constructor(private reviewService: ReviewService, private LService: LoginService) { }

  ngOnInit() {
    this.user = this.LService.getUser();
    this.reviewService.getMovieReviewByUserId(this.user.id).subscribe(
      resp =>{
        this.reviews = resp;
      }
    );
    this.review = new Review();
  }


}
