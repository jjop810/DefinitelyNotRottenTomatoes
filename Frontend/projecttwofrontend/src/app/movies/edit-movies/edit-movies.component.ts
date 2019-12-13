import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Movies } from '../shared/movies';
import { MoviesService } from '../shared/movies.service';

@Component({
  selector: 'app-edit-movies',
  templateUrl: './edit-movies.component.html',
  styleUrls: ['./edit-movies.component.css']
})
export class EditMoviesComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() mov: Movies;

  idy: number;
  titl: string;
  leng: number;
  rate: number;
  imgul: string;

  constructor(private movieService: MoviesService) { }

  ngOnInit() {
    //dummy data
    this.mov = new Movies();
    this.mov = this.getMovie("ABCDxyz");

    this.idy = this.mov.id;
    this.titl = this.mov.title;
    this.leng = this.mov.movieLength;
    this.rate = this.mov.rating;
    this.imgul = this.mov.imgUrl;

    

    (<HTMLInputElement>document.getElementById("id")).value = ""+this.idy;
    (<HTMLInputElement>document.getElementById("title")).value = this.titl;
    (<HTMLInputElement>document.getElementById("length")).value = ""+ this.leng;
    (<HTMLInputElement>document.getElementById("rating")).value = ""+this.rate;
    (<HTMLInputElement>document.getElementById("imgurl")).value = this.imgul;
    
  }

  getMovie(title:string): Movies{
    
    this.movieService.getMovie(title).subscribe(resp =>{
      this.mov = resp;
    });

    return this.mov;
  }

  editMovie(){
    console.log("Update movie: "); 
    console.log(this.mov);
    this.movieService.updateMovie(this.mov).subscribe(
      resp => {
        this.created.emit(true);
      });
      (<HTMLInputElement> document.getElementById("submit")).disabled = true;
  }

}
