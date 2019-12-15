import { Component, OnInit } from '@angular/core';
import { Genre } from '../genre-shared/genre';
import { GenreService } from '../genre-shared/genre.service';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {
  genres: Genre[];
  genre: Genre;
  constructor(
    private genreService: GenreService,
  ) { }

  ngOnInit() {
    this.genre = new Genre();
    this.genreService.getGenres().subscribe(
      (g) => {
        this.genres = g;
        this.genres.sort( (g1, g2) => g1.id - g2.id );
      });
  }

  


}
