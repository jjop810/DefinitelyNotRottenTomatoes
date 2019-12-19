import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { LoginService } from 'src/app/login.service';
import { WatchlistService} from 'src/app/watchlist.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Watchlist } from 'src/app/watchlist';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  watchlist: Watchlist;
  constructor(
    private moviesService: MoviesService,
    private loginService: LoginService,
    private watchlistService: WatchlistService,
    private route: Router
  ) { }

  ngOnInit() {
    console.log(this.movies);
  }
  addWatchlist() {
    console.log('Adding to watchlist');
    this.watchlist = {
      id: 1,
      userId: this.loginService.getUser(),
      movieId: this.movies.id,
      showId: null,
      title: this.movies.title };
    const userId = this.loginService.getUser();
    // tslint:disable-next-line: radix
    this.watchlistService.addWatchlist(this.watchlist).subscribe();
  }
  editMovie() {
    this.route.navigate(['movies/edit', this.movies.id]);
  }
}
