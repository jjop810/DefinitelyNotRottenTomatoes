import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { FriendsService } from '../friends.service';
import { User } from '../user';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  @Input() friend: User;
  @Output() submitted = new EventEmitter<boolean>();
  constructor(
    private userService: UserService,
    private friendService: FriendsService
  ) { }

  ngOnInit() {
    if (!this.friend) {
      this.friend = new User();
    }
  }

  updateFriend(): void {
    this.friendService.updateFriend(this.friend).subscribe(
      friend => {
        this.friend = friend;
        this.submitted.emit(true);
      }
    );
  }

  // isFriend(): boolean {
  //   return this.userService.isFriend();
  // }

}
