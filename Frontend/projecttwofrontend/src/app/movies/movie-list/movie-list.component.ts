import { Component, OnInit } from '@angular/core';
import { MoviesService } from '../shared/movies.service';
import { Movies } from '../shared/movies';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  mov:Movies;
  movs:Movies[];

  constructor(private movieService: MoviesService) { }

  ngOnInit() {
    this.movieService.getMovies().subscribe(resp =>{
      this.movs = resp;
    });
    this.mov = new Movies();
  }

/*
  submitted() {
    
    this.movl = new Movies();
    
  }
*/
}
