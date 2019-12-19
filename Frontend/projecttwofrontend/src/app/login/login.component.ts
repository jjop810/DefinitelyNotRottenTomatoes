import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../currentuser';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loggedUser: Currentuser;
  public username: string;
  public password: string;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.loginService.login(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      }
    );
  }

  login(){
    this.loginService.login(this.username, this.password).subscribe(
      resp =>{
        this.loggedUser = resp;
      }
    );
  }

  logout(){
    this.loginService.logout().subscribe(
      resp => {
        this.loggedUser = null;
        
      }

    );
  }

}
