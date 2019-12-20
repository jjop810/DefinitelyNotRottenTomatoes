import { Component, OnInit, Input } from '@angular/core';
import { Movierating } from '../movierating';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

  @Input() rating: Movierating;
  constructor() { }

  ngOnInit() {
  }

}
