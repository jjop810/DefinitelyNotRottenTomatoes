import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies: Movies[];
  constructor(
    private moviesService: MoviesService) { }

  ngOnInit() {
    this.moviesService.getMovies().subscribe(
      resp => {
        this.movies = resp;
      }
    );
  }

}
