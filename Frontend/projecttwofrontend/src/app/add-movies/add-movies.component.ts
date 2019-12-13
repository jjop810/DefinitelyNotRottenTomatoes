import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movies } from '../movies';
import { MoviesService } from '../movies.service';


@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrls: ['./add-movies.component.css']
})
export class AddMoviesComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() movl: Movies;


  constructor(private movieService: MoviesService) { }

  ngOnInit() { 
    this.movl = new Movies();
  }

  addMovie() { 
    //console.log("created: "+this.created);
    console.log("this is component var: ");
    console.log(this.movl.title);
    this.movieService.addMovie(this.movl).subscribe(
      resp => {
        this.created.emit(true);
      });
      (<HTMLInputElement> document.getElementById("btnExcel")).disabled = true;
      location.reload();
    }


}
