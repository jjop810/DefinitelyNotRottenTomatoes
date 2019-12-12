import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movies } from '../movies';
import { MoviesService } from '../movies.service';


@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() m: Movies;


  constructor(private movieService: MoviesService) { }

  ngOnInit() { 
  }

  addMovie() {
    this.movieService.addMovie(this.m).subscribe(
      resp => {
        this.created.emit(true);
      });
    }
}