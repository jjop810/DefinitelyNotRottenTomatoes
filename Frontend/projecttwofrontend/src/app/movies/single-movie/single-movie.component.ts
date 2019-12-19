import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-single-movie',
  templateUrl: './single-movie.component.html',
  styleUrls: ['./single-movie.component.css']
})
export class SingleMovieComponent implements OnInit {
  @Input() movies: Movies;
  constructor(private loginService: LoginService,
    private moviesService: MoviesService, private route: Router
  ) {}

  ngOnInit() {
  }
  editMovie() {
    this.route.navigate(['movies/edit', this.movies.id]);
  }
 
  rateMovie(){
    this.route.navigate(['movies/rating',this.movies.id]);
  }

  isUser(): boolean{
    return this.loginService.isUser();
  }
  isAdmin(): boolean{
    return this.loginService.isAdmin();
  }
}
