import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { WatchlistService} from 'src/app/watchlist.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { MrserviceService } from 'src/app/movierating/mrservice.service';
import { Movierating } from 'src/app/movierating/movierating';
import { Watchlist } from 'src/app/watchlist';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  mra: Movierating[];
  num: number;
  watchlist: Watchlist;
  constructor(
    private moviesService: MoviesService,private loginService: LoginService, private route: Router, private watchlistService: WatchlistService, private mrService: MrserviceService
  ) {}


  ngOnInit() {
    this.num = 0;
    this.mrService.getMovieRatingByMovieId(this.movies.id).subscribe(
      resp => {this.mra = resp;
               for (let i = 0 ; i < this.mra.length; i++) {
          this.num += this.mra[i].ratingvalue;
        }
          if(this.num>0){
               this.num = this.num / this.mra.length;}
              
               this.movies.rating = this.num;

      }
    );

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
  rateMovie(){
    this.route.navigate(['movies/rating', this.movies.id]);
  }
  reviewMovie(){
    this.route.navigate(['movies/review', this.movies.id]);
  }
  viewReviews(){
    this.route.navigate(['movies/review/view', this.movies.id]);
  }
  isUser(): boolean{
    return this.loginService.isUser();
  }
  isAdmin(): boolean{
    return this.loginService.isAdmin();
  }
}
