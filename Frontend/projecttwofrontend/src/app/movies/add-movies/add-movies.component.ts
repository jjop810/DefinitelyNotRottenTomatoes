import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';
import { Genre } from 'src/app/all-shared/genre-shared/genre';
import { GenreService } from 'src/app/all-shared/genre-shared/genre.service';


@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrls: ['./add-movies.component.css']
})
export class AddMoviesComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() movl: Movies;

  public genreList: Genre[];


  constructor(private movieService: MoviesService,private genreService: GenreService) { 
    
  }

  ngOnInit() { 
    this.movl = new Movies();
    this.movl.genres = [];

    this.genreService.getGenres().subscribe(
      genres => {
        this.genreList = genres;
        console.log(this.genreList);
      }
    );
    
  }

  addMovie() { 
    //console.log("created: "+this.created);
    console.log("this is component var: ");
    console.log(this.movl.title);
    if(this.movl.title){
      this.movieService.addMovie(this.movl).subscribe(
        resp => {
          this.created.emit(true);
        });
        (<HTMLInputElement> document.getElementById("submit")).disabled = true;
    }else{
      console.log("You didn't put in a title!");
    }
    
      //location.reload();
    }

    removeGenre(a: Genre): void {
      // remove the genre from the movl
      this.movl.genres.splice(this.movl.genres.indexOf(a), 1);
      // add the genre to the list
      this.genreList.push(a);
    }
  
    addGenre(a: Genre): void {
      // add into movl
      this.movl.genres.push(a);
      // remove from list
      this.genreList.splice(this.genreList.indexOf(a), 1);
    }


}
