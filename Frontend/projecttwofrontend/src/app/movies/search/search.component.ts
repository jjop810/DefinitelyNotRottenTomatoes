import { Component, OnInit, Input } from '@angular/core';
import { SearchService } from 'src/app/shared/search.service';
import { Movies } from '../shared/movies';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchTxt: string;
  movies: Movies[];
  page = 1;
  lastPage: number;
  jumpToPage: number;

  constructor(private searchService: SearchService, private route: ActivatedRoute,  private route2: Router) { }

  ngOnInit() {
    this.searchTxt = this.route.snapshot.params['searchTxt'];
    this.search();
    this.searchService.getLastPage().subscribe(
      resp => {
        this.lastPage = resp;
      }
    );
    this.searchTxt = null;
  }

  search(): void {
    this.route2.navigate(['movies/search', this.searchTxt]);
    if (this.searchTxt) {
      console.log(this.searchTxt);
      this.searchService.getMovieSearch(this.searchTxt, 1).subscribe(
        resp => {
          this.movies = resp;
        }
      );
    }
  }
  nextPage(): void {
    this.page += 1;
    if (this.page > this.lastPage) {
      this.page = 1;
    }
    this.searchService.getMovieSearch(this.searchTxt, this.page).subscribe(
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
    this.searchService.getMovieSearch(this.searchTxt, this.page).subscribe(
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
    this.searchService.getMovieSearch(this.searchTxt, this.page).subscribe(
      resp => {
        this.movies = resp;
      }
    );
    this.jumpToPage = null;
  }
  goTop() {
    window.scroll(0, 0);
  }
}
