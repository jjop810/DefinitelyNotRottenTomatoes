import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Shows } from '../shared/shows';
import { ShowsService } from '../shared/shows.service';
import { Genre } from 'src/app/all-shared/genre-shared/genre';
import { GenreService } from 'src/app/all-shared/genre-shared/genre.service';

@Component({
  selector: 'app-add-shows',
  templateUrl: './add-shows.component.html',
  styleUrls: ['./add-shows.component.css']
})
export class AddShowsComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() showl: Shows;

  
  public genreList: Genre[];


  constructor(private showService: ShowsService,private genreService: GenreService) { }

  ngOnInit() { 
    this.showl = new Shows();
    this.showl.genres = [];

    this.genreService.getGenres().subscribe(
      genres => {
        this.genreList = genres;
        console.log(this.genreList);
      }
    );
  }

  addShow() { 
    //console.log("created: "+this.created);
    console.log("this is component var: ");
    console.log(this.showl.title);
    this.showService.addShow(this.showl).subscribe(
      resp => {
        this.created.emit(true);
      });
      (<HTMLInputElement> document.getElementById("submit")).disabled = true;
      //location.reload();
    }

    
    removeGenre(a: Genre): void {
      // remove the genre from the showl
      this.showl.genres.splice(this.showl.genres.indexOf(a), 1);
      // add the genre to the list
      this.genreList.push(a);
    }
  
    addGenre(a: Genre): void {
      // add into showl
      this.showl.genres.push(a);
      // remove from list
      this.genreList.splice(this.genreList.indexOf(a), 1);
    }


}
