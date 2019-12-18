import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { SearchService } from 'src/app/shared/search.service';
@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies: Movies[];
  lastPage: number;
  jumpToPage: number;
  searchTxt: string;
  page = 1;
  constructor(private moviesService: MoviesService, private searchService: SearchService) { }
    ngOnInit() {
      console.log(this.searchTxt);
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
    jumpPage(): void {
      if (this.jumpToPage > this.lastPage) {
        this.jumpToPage = this.lastPage;
        this.page = this.jumpToPage;
      } else if (this.jumpToPage < 1) {
        this.jumpToPage = 1;
        this.page = this.jumpToPage;
      }
      this.page = this.jumpToPage;
      this.moviesService.getMovies(this.jumpToPage).subscribe(
        resp => {
          this.movies = resp;
        }
        );
  }
      }

      search(): void {
        if (this.searchTxt) {
        this.searchService.getMovieSearch(this.searchTxt, 1).subscribe(
          resp => {
            this.movies = resp;
          }
        );
        }
      }
}
