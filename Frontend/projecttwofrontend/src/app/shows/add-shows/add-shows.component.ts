import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Shows } from '../shared/shows';
import { ShowsService } from '../shared/shows.service';

@Component({
  selector: 'app-add-shows',
  templateUrl: './add-shows.component.html',
  styleUrls: ['./add-shows.component.css']
})
export class AddShowsComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() showl: Shows;


  constructor(private showService: ShowsService) { }

  ngOnInit() { 
    this.showl = new Shows();
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

}
