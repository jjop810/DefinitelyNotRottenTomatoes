import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = ' Movies and Shows ';


  constructor(public route: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  isAdmin(): boolean{
    return this.loginService.isAdmin();
  }
  isUser(): boolean{
    return this.loginService.isUser();
  }

  
}
