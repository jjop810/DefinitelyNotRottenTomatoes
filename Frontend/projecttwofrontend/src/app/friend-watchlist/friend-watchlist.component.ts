import { Component, OnInit } from '@angular/core';
import { Movies } from '../movies/shared/movies';
import { WatchlistService } from '../watchlist.service';
import { LoginService } from '../login.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-friend-watchlist',
  templateUrl: './friend-watchlist.component.html',
  styleUrls: ['./friend-watchlist.component.css']
})
export class FriendWatchlistComponent implements OnInit {

  movies: Movies[];
  page = 1;
  lastPage: number;
  jumpToPage: number;
  searchTxt: string;
  friendUserId: number;
  friendUserName: string;
  constructor(
    private watchlistService: WatchlistService,
    private route: ActivatedRoute
  ) { }
  ngOnInit() {
    // tslint:disable-next-line: no-string-literal
    this.friendUserId = this.route.snapshot.params['userId'];
     // tslint:disable-next-line: no-string-literal
    this.friendUserName = this.route.snapshot.params['userName'];

    this.watchlistService.getFriendMovies(this.friendUserId, this.friendUserName, this.page).subscribe(
      resp => {
        this.movies = resp;
      }
    );
    this.watchlistService.getLastPage().subscribe(
      resp => {
        this.lastPage = resp;
      }
    );
  }

  nextPage(): void {
    console.log('Last Page: ' + this.lastPage);
    this.page += 1;
    if (this.page > this.lastPage) {
      this.page = 1;
    }
    this.watchlistService.getFriendMovies(this.friendUserId, this.friendUserName, this.page).subscribe(
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
    this.watchlistService.getFriendMovies(this.friendUserId, this.friendUserName, this.page).subscribe(
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
    this.watchlistService.getFriendMovies(this.friendUserId, this.friendUserName, this.page).subscribe(
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
      this.watchlistService.getMovieSearch(this.searchTxt, 1, this.friendUserId).subscribe(
        resp => {
          this.movies = resp;
        }
      );
    }
    this.searchTxt = null;
  }
  goTop() {
    window.scroll(0, 0);
  }

}
