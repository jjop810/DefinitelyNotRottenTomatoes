import { Component, OnInit, Input } from '@angular/core';
import { Friend } from '../friend';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {

  @Input() friend: Friend;
  constructor() { }

  ngOnInit() {
  }

}
