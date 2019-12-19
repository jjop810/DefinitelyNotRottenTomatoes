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
  page = 1;
  lastPage: number;
  jumpToPage: number;
  searchTxt: string;
  constructor(
    private watchlistService: WatchlistService,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    console.log(this.movies);
    this.watchlistService.getMovies(this.loginService.getUser(), this.page).subscribe(
      resp => {
        this.movies = resp;
        //console.log('Get Watchlist');
      }
    );
    this.watchlistService.getLastPage().subscribe(
      resp => {
        this.lastPage = resp;
        //console.log('Get page number');
        //this.lastPage += 1;
      }
    );
  }

  nextPage(): void {
    console.log('Last Page: ' + this.lastPage);
    this.page += 1;
    if (this.page > this.lastPage) {
      this.page = 1;
    }
    this.watchlistService.getMovies(this.loginService.getUser(), this.page).subscribe(
      resp => {
        this.movies = resp;
      }
    );
  }
  previousPage(): void {
    this.page -= 1;
    if (this.page < 1) {
      this.page = this.lastPage;
    }
    this.watchlistService.getMovies(this.loginService.getUser(), this.page).subscribe(
      resp => {
        this.movies = resp;
      }
    );
  }
  jumpPage(): void {
    if (this.jumpToPage > this.lastPage) {
      this.jumpToPage = this.lastPage;
      this.page = this.jumpToPage;
    } else if (this.jumpToPage < 1) {
      this.jumpToPage = 1;
      this.page = this.jumpToPage;
    }
    this.page = this.jumpToPage;
    this.watchlistService.getMovies(this.loginService.getUser(), this.jumpToPage).subscribe(
      resp => {
        this.movies = resp;
      }
    );
    this.jumpToPage = null;
  }
  search(): void {
    console.log('search called');
    if (this.searchTxt) {
      console.log(this.searchTxt);
      this.watchlistService.getMovieSearch(this.searchTxt, 1).subscribe(
        resp => {
          this.movies = resp;
        }
      );
    }
    this.searchTxt = null;
  }
}
