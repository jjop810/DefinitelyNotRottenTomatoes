import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  constructor(
    private moviesService: MoviesService, private route: Router
  ) {}

  ngOnInit() {
  }
  editMovie() {
    this.route.navigate(['movies/edit', this.movies.id]);
  }
  reviewMovie(){
    this.route.navigate(['movies/review', this.movies.id]);
  }
}
