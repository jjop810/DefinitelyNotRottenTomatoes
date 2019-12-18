import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { GenreService } from 'src/app/all-shared/genre-shared/genre.service';
import { Genre } from 'src/app/all-shared/genre-shared/genre';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-edit-movies',
  templateUrl: './edit-movies.component.html',
  styleUrls: ['./edit-movies.component.css']
})
export class EditMoviesComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() mov: Movies;
  movies$: Observable<Movies[]>;
  public genreList: Genre[];

  idy: number;
  titl: string;
  leng: number;
  rate: number;
  imgul: string;

  constructor(private movieService: MoviesService, private genreService: GenreService, 
              private routeTo: Router,  private route: ActivatedRoute) { }

  ngOnInit() {

    console.log(this.route.snapshot.params['id']);
    //dummy data
    this.mov = new Movies();
    //this.mov = this.getMovie("MovieTesty");

    this.movieService.getMovieById(this.route.snapshot.params['id']).subscribe(
      movie => {
        // set current movie to the movie retrieved.
        this.mov = movie;
        // retrieve all genres and splice the movie's genres out of that list.

        this.genreService.getGenres().subscribe(
          genres => {
            this.genreList = genres;
            if (this.mov.genres) {
              this.mov.genres.forEach(
                genre => this.genreList.splice(this.genreList.indexOf(genre, 1))
              );
            }
          }
        );
      }
    );



    this.idy = this.mov.id;
    this.titl = this.mov.title;
    this.leng = this.mov.movieLength;
    this.rate = this.mov.rating;
    this.imgul = this.mov.imgUrl;



    (<HTMLInputElement>document.getElementById("id")).value = "" + this.idy;
    (<HTMLInputElement>document.getElementById("title")).value = this.titl;
    (<HTMLInputElement>document.getElementById("length")).value = "" + this.leng;
    (<HTMLInputElement>document.getElementById("rating")).value = "" + this.rate;
    (<HTMLInputElement>document.getElementById("imgurl")).value = this.imgul;

  }

  getMovie(title: string): Movies {

    this.movieService.getMovie(title).subscribe(resp => {
      this.mov = resp;
      console.log("get movie: ");
      console.log(resp);
    });

    return this.mov;
  }

  editMovie() {
    console.log("Update movie: ");
    console.log(this.mov);
    this.movieService.updateMovie(this.mov).subscribe(
      resp => {
        this.created.emit(true);
      });
    (<HTMLInputElement>document.getElementById("submit")).disabled = true;
    this.routeTo.navigateByUrl('home');
  }

  removeGenre(a: Genre): void {
    // remove the genre from the movl
    this.mov.genres.splice(this.mov.genres.indexOf(a), 1);
    // add the genre to the list
    this.genreList.push(a);
  }

  addGenre(a: Genre): void {
    // add into movl
    console.log(a);
    console.log(this.mov.genres);
    
    var found = false;
    for (var i = 0; i < this.mov.genres.length; i++) {
      if (this.mov.genres[i].genreName === a.genreName) {
        found = true;
        break;
      }
    }
    console.log(found);
    if (found) {
      console.log("This genre is already in the movie!");
    } else {
      this.mov.genres.push(a);
      // remove from list
      this.genreList.splice(this.genreList.indexOf(a), 1);
    }
  }


}
