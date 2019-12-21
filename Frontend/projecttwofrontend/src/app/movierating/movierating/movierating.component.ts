import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Movierating } from '../movierating';
import { MrserviceService } from '../mrservice.service';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from 'src/app/movies/shared/movies.service';
import { Movies } from 'src/app/movies/shared/movies';
import { User } from 'src/app/user';
import { LoginService } from 'src/app/login.service';


@Component({
  selector: 'app-movierating',
  templateUrl: './movierating.component.html',
  styleUrls: ['./movierating.component.css']
})
export class MovieratingComponent implements OnInit {

  @Output() created = new EventEmitter<Boolean>();
  @Input() movierating: Movierating;
  @Input() movieout: Movies;
  @Input() user: User;

  // for auto-filling the rating value
  mratings: Movierating[] = []
  movid: number;
  rvalue: number;



  
  // tslint:disable-next-line: max-line-length
  constructor(private movieService: MoviesService , private mrService: MrserviceService, private loginService: LoginService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.movierating = new Movierating();
    this.movieout = new Movies();
    this.user = this.loginService.getUser();
    this.movieService.getMovieById(this.route.snapshot.params.id).subscribe(
      resp => {
      this.movieout = resp;
      console.log(this.movieout); }
      );
    this.mrService.getMovieRatingByUserId(this.user.id).subscribe(
      resp =>{
        this.mratings = resp;
        for( let i=0 ; i< this.mratings.length ; i++){
            if(this.mratings[i].movie.id === this.movieout.id){
              this.rvalue = this.mratings[i].ratingvalue;
              this.movierating.ratingvalue = this.rvalue;
            }
        }
      }
    );

    }

  addMovieRatingorUpdate(){
    this.movierating.user = this.user;
    this.movierating.movie = this.movieout;
    this.mrService.CheckMovieRating(this.movierating).subscribe(
      resp => {this.created.emit(true)}
    );

    console.log('ratings added!!');

  }


  

}
