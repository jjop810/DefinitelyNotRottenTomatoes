import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../review-shared/review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  constructor(reviewService: ReviewService) { }

  ngOnInit() {
  }

}
