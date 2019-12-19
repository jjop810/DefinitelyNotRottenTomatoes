import { OnInit, Component } from '@angular/core';
import { Movies } from '../movies/shared/movies';
import { LoginService } from '../login.service';
import { WatchlistService } from '../watchlist.service';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {
  movies: Movies[];
  constructor(
    private watchlistService: WatchlistService,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    console.log(this.movies);
    this.watchlistService.getMovies(this.loginService.getUser()).subscribe(
      resp => {
        this.movies = resp;
        console.log(this.movies);
      }
    );
  }
}
