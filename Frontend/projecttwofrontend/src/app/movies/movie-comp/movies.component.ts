import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies: Movies[];
  lastPage: number;
  page = 1;
  constructor(
    private moviesService: MoviesService) { }
    ngOnInit() {
      this.moviesService.getMovies(this.page).subscribe(
        resp => {
          this.movies = resp;
        }
        );
      this.moviesService.getLastPage().subscribe(
        resp => {
          this.lastPage = resp;
        }
      );
      }
      nextPage(): void {
        console.log(this.lastPage);
        this.page += 1;
        if (this.page > this.lastPage) {
          this.page = 1;
        }
        this.moviesService.getMovies(this.page).subscribe(
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
        this.moviesService.getMovies(this.page).subscribe(
          resp => {
            this.movies = resp;
          }
          );
    }
}