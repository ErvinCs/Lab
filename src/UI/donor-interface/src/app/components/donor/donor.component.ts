import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-donor',
  templateUrl: './donor.component.html',
  styleUrls: ['./donor.component.css']
})
export class DonorComponent implements OnInit {
  private _lastDonation: Date;
  private _nextAppointment: Date;
  private _history;

  get history(): Date[] {
    return this._history;
  }
  get nextAppoinment(): Date {
    return this._nextAppointment;
  }
  get lastDonation(): Date {
    return this._lastDonation;
  }

  constructor() {
    this._nextAppointment = new Date(532831920831);
    this._lastDonation = new Date(432876432);
    this._history = new Array();
    this._history.push(new Date(1));
    this._history.push(new Date(2));
    this._history.push(new Date(3));
    this._history.push(new Date(4));
  }

  ngOnInit() {
    // TODO: Get the values from an ajax call
    let currentDate = new Date();
    if (currentDate === this._nextAppointment) {
      this._history.push(this._nextAppointment);
    }
    // console.log(this);
  }
}
