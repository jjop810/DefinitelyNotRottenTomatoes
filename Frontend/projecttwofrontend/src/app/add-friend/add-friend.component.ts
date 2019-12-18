import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { User } from '../user';
import { FriendsService } from '../friends.service';

@Component({
  selector: 'app-add-friend',
  templateUrl: './add-friend.component.html',
  styleUrls: ['./add-friend.component.css']
})
export class AddFriendComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() friend: User;
  constructor(private friendService: FriendsService ) { }

  ngOnInit() {
  }
  addFriend() {
    this.friendService.addFriend(this.friend).subscribe(
      resp => {
        this.created.emit(true);
      }
    );
  }

}
