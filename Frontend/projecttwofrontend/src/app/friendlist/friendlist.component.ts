import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Friend } from '../friend';

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
    this.userService.getUsers().subscribe(resp=>{
      this.users = resp;
    });
    this.user = new User();
    //this.user.friends = new Friend();
  }

}
