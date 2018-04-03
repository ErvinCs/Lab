import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {
  private email: String;
  private password: String;

  constructor() { }

  ngOnInit() {

  }

  loginUser(email: String, password: String) {
    // Make the ajax call for the user, to see if it logins or not
    // Make a cookie to know that we are in a session
  }

}
