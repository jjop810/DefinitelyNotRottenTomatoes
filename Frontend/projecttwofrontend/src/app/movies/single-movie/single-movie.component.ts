import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { LoginService } from 'src/app/login.service';
import { WatchlistService} from 'src/app/watchlist.service';
import { Router, ActivatedRoute } from '@angular/router';

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
    private watchlistService: WatchlistService,
    private route: Router
  ) { }

  ngOnInit() {
    console.log(this.movies);
  }
  addWatchlist() {
    console.log('Adding to watchlist');
    const userId = this.loginService.getUser().id;
    // tslint:disable-next-line: radix
    this.watchlistService.addWatchlist(parseInt(userId), this.movies.id);
  }
  editMovie() {
    this.route.navigate(['movies/edit', this.movies.id]);
  }
}
