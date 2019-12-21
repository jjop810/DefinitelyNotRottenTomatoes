import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { MrserviceService } from 'src/app/movierating/mrservice.service';
import { Movierating } from 'src/app/movierating/movierating';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  mra: Movierating[];
  num: number;
  constructor(private loginService: LoginService, private moviesService: MoviesService, private route: Router, private mrService: MrserviceService,
  ) {}

  ngOnInit() {
    this.num = 0;
    this.mrService.getMovieRatingByMovieId(this.movies.id).subscribe(
      resp => {this.mra = resp;
               for (let i = 0 ; i < this.mra.length; i++) {
          this.num += this.mra[i].ratingvalue;
        }
               this.num = this.num / this.mra.length;

               console.log(this.num);
               this.movies.rating = this.num;

      }
    );

  }
  editMovie() {
    this.route.navigate(['movies/edit', this.movies.id]);
  }
 
  rateMovie(){
    this.route.navigate(['movies/rating', this.movies.id]);
  }

  isUser(): boolean{
    return this.loginService.isUser();
  }
  isAdmin(): boolean{
    return this.loginService.isAdmin();
  }

  
}
