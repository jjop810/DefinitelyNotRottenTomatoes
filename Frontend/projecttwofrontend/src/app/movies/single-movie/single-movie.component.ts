import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  constructor(
    private moviesService: MoviesService
  ) { }

  ngOnInit() {
    console.log(this.movies);
  }

}
