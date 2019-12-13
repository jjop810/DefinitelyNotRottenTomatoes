import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';


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


}
