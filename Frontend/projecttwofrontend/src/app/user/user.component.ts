import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  public colors = ['red', 'blue', 'green'];

  // public username: string;
  // public password: string;
  // public i: number;
  // @Output() created = new EventEmitter<Boolean>();
   @Input() user: User;
  constructor() { }

  ngOnInit() {
    // this.userService.getUsers().subscribe(resp =>{
    //   this.users = resp;
    // });
  }
  login(){
    
  }
  change(){
    //this.name = 'works';
  }

}
