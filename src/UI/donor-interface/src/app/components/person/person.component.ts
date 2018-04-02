import { Component, OnInit } from '@angular/core';

import { Address } from '../common/Address.interface';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
  private _email: String;
  private _password: String;
  private _firstName: String;
  private _lastName: String;
  private _birthday: Date;
  private _address: Address;
  private _residence: Address;
  private _cnp: number;

  constructor() { }

  ngOnInit() {
  }

  submitPersonInfo() {

  }

  submitData(email:String, password: String, firstName: String, lastName: String, birthday:Date, 
      address:String, town: String, city: String, cnp: number) {
    this._email = email;
    this._password = password;
    this._firstName = firstName;
    this._lastName = lastName;
    this._birthday = birthday;
    let home = {
      street: address,
      city: city,
      town: town
    }
    this._address = home;
    this._cnp = cnp;
    // console.log(this);
    // Also will do other stuff
    // Will go to the server with a ajax call
    // Will check if it's valid, then back
    return false;
  }
}

