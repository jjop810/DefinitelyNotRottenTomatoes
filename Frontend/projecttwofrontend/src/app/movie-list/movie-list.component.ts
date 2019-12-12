import { Component, OnInit } from '@angular/core';
import { MoviesService } from '../movies.service';
import { Movies } from '../movies';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  m:Movies;
  movs:Movies[];

  constructor(private movieService: MoviesService) { }

  ngOnInit() {
    this.movieService.getMovies().subscribe(resp =>{
      this.movs = resp;
    });
    this.m = new Movies();
  }

}