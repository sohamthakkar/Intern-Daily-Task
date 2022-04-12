import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-from',
  templateUrl: './user-from.component.html',
  styleUrls: ['./user-from.component.scss']
})
export class UserFromComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  userSignup(userForm: any) {
    console.log(userForm);
  }
}
