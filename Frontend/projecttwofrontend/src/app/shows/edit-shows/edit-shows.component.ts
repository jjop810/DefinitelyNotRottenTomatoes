import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Shows } from '../shared/shows';
import { ShowsService } from '../shared/shows.service';
import { GenreService } from 'src/app/all-shared/genre-shared/genre.service';
import { Genre } from 'src/app/all-shared/genre-shared/genre';

@Component({
  selector: 'app-edit-shows',
  templateUrl: './edit-shows.component.html',
  styleUrls: ['./edit-shows.component.css']
})
export class EditShowsComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() show: Shows;

  public genreList: Genre[];

  idy: number;
  titl: string;
  episo: number;
  rate: number;
  imgul: string;

  constructor(private showService: ShowsService, private genreService: GenreService) { }

  ngOnInit() {
    //dummy data
    this.show = new Shows();
   
    //this.show = this.getshowie("showieTesty");

    this.showService.getShow("Just Cause").subscribe(
      showi => {
        // set current showie to the showie retrieved.
        this.show = showi;
        // retrieve all genres and splice the showie's genres out of that list.

        this.genreService.getGenres().subscribe(
          genres => {
            this.genreList = genres;
            if (this.show.genres) {
              this.show.genres.forEach(
                genre => this.genreList.splice(this.genreList.indexOf(genre, 1))
              );
            }
          }
        );
      }
    );


    this.idy = this.show.id;
    this.titl = this.show.title;
      this.episo = this.show.episodes;
    this.rate = this.show.rating;
    this.imgul = this.show.imgUrl;

    

    (<HTMLInputElement>document.getElementById("id")).value = ""+this.idy;
    (<HTMLInputElement>document.getElementById("title")).value = this.titl;
    (<HTMLInputElement>document.getElementById("episodes")).value = ""+ this.episo;
    (<HTMLInputElement>document.getElementById("rating")).value = ""+this.rate;
    (<HTMLInputElement>document.getElementById("imgurl")).value = this.imgul;
    
  }

  getShow(title:string): Shows{
    
    this.showService.getShow(title).subscribe(resp =>{
      this.show = resp;
    });

    return this.show;
  }

  editShow(){
    console.log("Update Show: "); 
    console.log(this.show);
    this.showService.updateShow(this.show).subscribe(
      resp => {
        this.created.emit(true);
      });
      (<HTMLInputElement> document.getElementById("submit")).disabled = true;
  }

  
  removeGenre(a: Genre): void {
    // remove the genre from the showl
    this.show.genres.splice(this.show.genres.indexOf(a), 1);
    // add the genre to the list
    this.genreList.push(a);
  }

  addGenre(a: Genre): void {
    // add into movl
    console.log(a);
    console.log(this.show.genres);
    
    var found = false;
    for (var i = 0; i < this.show.genres.length; i++) {
      if (this.show.genres[i].genreName === a.genreName) {
        found = true;
        break;
      }
    }
    console.log(found);
    if (found) {
      console.log("This genre is already in the show!");
    } else {
      this.show.genres.push(a);
      // remove from list
      this.genreList.splice(this.genreList.indexOf(a), 1);
    }
  }



}
