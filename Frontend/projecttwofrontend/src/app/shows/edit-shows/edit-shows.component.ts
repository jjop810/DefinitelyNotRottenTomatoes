import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Shows } from '../shared/shows';
import { ShowsService } from '../shared/shows.service';

@Component({
  selector: 'app-edit-shows',
  templateUrl: './edit-shows.component.html',
  styleUrls: ['./edit-shows.component.css']
})
export class EditShowsComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() show: Shows;

  idy: number;
  titl: string;
  leng: number;
  rate: number;
  imgul: string;

  constructor(private showService: ShowsService) { }

  ngOnInit() {
    //dummy data
    this.show = new Shows();
    this.show = this.getShow("ABCDxyz");

    this.idy = this.show.id;
    this.titl = this.show.title;
   
    this.rate = this.show.rating;
    this.imgul = this.show.imgUrl;

    

    (<HTMLInputElement>document.getElementById("id")).value = ""+this.idy;
    (<HTMLInputElement>document.getElementById("title")).value = this.titl;
    (<HTMLInputElement>document.getElementById("length")).value = ""+ this.leng;
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


}
