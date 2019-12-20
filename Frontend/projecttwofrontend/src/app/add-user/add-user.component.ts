import { Component, OnInit, Output,EventEmitter, Input } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  @Output() created = new EventEmitter<Boolean>();
  @Input() user: User;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private userService: UserService,  private routeTo: Router) { }

  ngOnInit() {
  }

  addUser(){
    this.successMessage = '';
    this.errorMessage = '';
    this.userService.addUser(this.user).subscribe(
      resp => {
        this.created.emit(true);
        this.successMessage = 'Added!';
      }
    );
    // this.routeTo.navigateByUrl('home');
  }
  backHome(){
        this.routeTo.navigateByUrl('home');

  }

}
