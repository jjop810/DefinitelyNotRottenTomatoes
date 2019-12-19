import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Movierating } from '../movierating';
import { MrserviceService } from '../mrservice.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MoviesService } from 'src/app/movies/shared/movies.service';
import { Observable } from 'rxjs';
import { Movies } from 'src/app/movies/shared/movies';
import { Genre } from 'src/app/all-shared/genre-shared/genre';
import { GenreService } from 'src/app/all-shared/genre-shared/genre.service';
import { User } from 'src/app/user';
import { LoginService } from 'src/app/login.service';
import { UserService } from 'src/app/user.service';


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
  movierate: Movierating;

  
  // tslint:disable-next-line: max-line-length
  constructor(private movieService: MoviesService , private mrService: MrserviceService,private userService: UserService, private loginService: LoginService, private routeTo: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  
    this.movierating = new Movierating();
    this.movieout = new Movies();
    this.user = this.loginService.getUser();
    
    this.movieService.getMovieById(this.route.snapshot.params.id).subscribe(resp => {
      this.movieout = resp;
      console.log(this.movieout); }
      );
    
  }

  addMovieRatingorUpdate(){
    this.movierating.user = this.user;
    console.log('this is '+ this.movierating.user);
    this.movierating.movie = this.movieout;
    console.log(this.movierating.movie);
    this.mrService.CheckMovieRating(this.movierating).subscribe(
      resp => {this.created.emit(true)}
    );
  }
  
  

}
