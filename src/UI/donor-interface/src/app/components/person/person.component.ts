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
    // If the person exists in the database, get it's data
  }

  submitPersonInfo() {
    // Make Ajax call for the database, to create the data for update || create
   }

  submitData(email: string, password: string, firstName: string, lastName: string, birthday: Date,
      address: string, town: string, city: string, cnp: number) {
    this._password = validatePassword(password);
    this._email = validateEmail(email);
    this._firstName = firstName.length < 2 ? firstName : null;
    this._lastName = lastName.length < 2 ? lastName : null;
    this._birthday = validateDate(birthday);
    this._address = checkAddress(address, city, town);
    this._cnp = validateCNP(cnp);
    return false;
  }

}

function validateEmail(email: string): String {
  let regexMail: RegExp = new RegExp('^[a-zA-Z0-9]+@[a-z0-9]+\.[a-z]+$');
  return regexMail.test(email) ? email : null;
}

function validatePassword(passwd: string): String {
  if (passwd.length < 8) {
    throw new Error("Password must be at least 8 characters long!");
  }
  return passwd;
}

function validateDate(date: Date): Date {
  let currentDate = new Date();
  // TODO: More validation for the date
  if (currentDate.getUTCFullYear() - date.getUTCFullYear() < 18) {
    throw new Error("You are not old enough to can donate blood!");
  }
  return date;
}

function checkAddress(street: String, city: String, town: String): Address {
  let address = {
    street: street,
    city: city,
    town: town
  }
  return address;
}

function validateCNP(cnp: number):number {
  let regexCnp: RegExp = new RegExp('^[1256][0-9]{12}$');
  //TODO: More data validation
  if (regexCnp.test(cnp.toString())) {
    throw new Error("Invalid CNP! Please check your data!")
  }
  return cnp;
}