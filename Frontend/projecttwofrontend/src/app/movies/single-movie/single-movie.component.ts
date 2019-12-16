import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { LoginService } from 'src/app/login.service';
import { WatchlistService} from 'src/app/watchlist.service';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  constructor(
    private moviesService: MoviesService,
    private loginService: LoginService,
    private watchlistService: WatchlistService
  ) { }

  ngOnInit() {
    console.log(this.movies);
  }
  addWatchlist() {
    console.log('Adding to watchlist');
    let user = this.loginService.getUser();
    // Get the id of the movie
    // Pass the userId and movieId to the watchlistService
  }

}
