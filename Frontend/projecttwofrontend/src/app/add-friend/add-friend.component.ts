import { Component, OnInit } from '@angular/core';
import { FriendService } from '../friend.service';
import { Friend } from '../friend';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-add-friend',
  templateUrl: './add-friend.component.html',
  styleUrls: ['./add-friend.component.css']
})
export class AddFriendComponent implements OnInit {
  friends: Friend[];
  constructor(private friendService: FriendService, private getUser: UserService) { }

  ngOnInit() {
   this.friendService.getFriends().subscribe(
     resp => {
       this.friends = resp;
       console.log(this.friends);
      }
      );
   this.addFriend();
  }

  addFriend() {
    let newFriend = new Friend();
    newFriend.user = this.friends[0].user;
    let user = new User();
    this.friendService.addFriend(newFriend[0]).subscribe();
  }

}
