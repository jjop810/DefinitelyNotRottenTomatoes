import { Component, OnInit, Output,EventEmitter, Input } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  @Output() created = new EventEmitter<Boolean>();
  @Input() user: User;
  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  addUser(){
    this.userService.addUser(this.user).subscribe(
      resp => {
        this.created.emit(true);
      }
    );
  }

}
