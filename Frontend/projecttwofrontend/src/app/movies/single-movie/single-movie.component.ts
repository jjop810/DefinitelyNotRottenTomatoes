import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { UserService } from 'src/app/user.service';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  constructor(
    private moviesService: MoviesService,
    private userService: UserService
  ) { }

  ngOnInit() {
    console.log(this.movies);
  }
  addWatchlist() {
    console.log('Adding to watchlist');
    let user = LoginService.getUser;

  }

}
