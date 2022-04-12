import { Component, OnInit } from '@angular/core';
import{ UserDataService } from  '../services/user-data.service'

@Component({
  selector: 'app-show-user',
  templateUrl: './show-user.component.html',
  styleUrls: ['./show-user.component.scss']
})
export class ShowUserComponent implements OnInit {

  users:any=[]
  constructor(private userData: UserDataService) {
    console.log(userData.users(), 'userData');
    this.users=this.userData.users()
  }

  ngOnInit(): void {
  }

}
