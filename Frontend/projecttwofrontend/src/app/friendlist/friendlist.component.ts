import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-friendlist',
  templateUrl: './friendlist.component.html',
  styleUrls: ['./friendlist.component.css']
})
export class FriendlistComponent implements OnInit {
  users: User[];
  user: User;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe( resp => {
      this.users = resp;
      console.log(resp);
    });
    this.user = new User();
    this.user.friends = [];
  }
  // submitted(){
  //   this.users.push(this.user);
  //   this.user = new User();
  //   this.user.friends = new Friends();
  // }
}
