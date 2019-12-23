import { Component, OnInit, Input } from '@angular/core';
import { Movierating } from '../movierating';
import { MrserviceService } from '../mrservice.service';
import { User } from 'src/app/user';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-urating-list',
  templateUrl: './urating-list.component.html',
  styleUrls: ['./urating-list.component.css']
})
export class UratingListComponent implements OnInit {

  ratings: Movierating[];
  rating: Movierating;
  user: User;
  constructor(private mrService: MrserviceService, private LService: LoginService) { }

  ngOnInit() {
    this.user = this.LService.getUser();
    this.mrService.getMovieRatingByUserId(this.user.id).subscribe(
      resp =>{
        this.ratings = resp;
      }
    );
    this.rating = new Movierating();
  }

}
