import { Component, OnInit, Input } from '@angular/core';
import { FriendService } from '../friend.service';
import { Friend } from '../friend';
import { UserService } from '../user.service';
import { User } from '../user';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-friend',
  templateUrl: './add-friend.component.html',
  styleUrls: ['./add-friend.component.css']
})
export class AddFriendComponent implements OnInit {
  currUser: User;
  friends = null;
  inputTxt: string;
  constructor(private friendService: FriendService, private getUser: UserService, private loginService: LoginService,
              private route: Router) { }

  ngOnInit() {
    this.currUser = this.loginService.getUser();
    console.log(this.currUser.friends);
  }

  searchFriend() {
      this.getUser.getUserByUsername(this.inputTxt).subscribe(resp => {
        this.friends = resp;

        console.log(this.friends);
       }
       );
    }
    addFriend() {
      console.log(this.friends);
      this.currUser.friends.push(this.friends);
      this.getUser.editUser(this.currUser).subscribe(resp => {
        this.currUser = resp;
       }
       );
    }
    viewFriendWatchList(userId: number, userName: string) {
      this.route.navigate(['addfriend/viewWatchlist', userId, userName] )
    }

    deleteFriend(user: User) {
      const temp = this.currUser.friends.filter((value) => {
        return value.id !== user.id;
      });
      this.currUser.friends = temp;
      this.getUser.editUser(this.currUser).subscribe(resp => {
        this.currUser = resp;
       }
       );
    }

}
