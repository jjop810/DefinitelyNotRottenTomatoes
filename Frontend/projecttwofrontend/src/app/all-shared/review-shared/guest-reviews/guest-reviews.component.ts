import { Component, OnInit, Input } from '@angular/core';
import { Review } from '../review';
import { User } from 'src/app/user';

@Component({
  selector: 'app-guest-reviews',
  templateUrl: './guest-reviews.component.html',
  styleUrls: ['./guest-reviews.component.css']
})
export class GuestReviewsComponent implements OnInit {

  @Input() review: Review;
  @Input() user: User;

  constructor() { }

  ngOnInit() {
  }

}
