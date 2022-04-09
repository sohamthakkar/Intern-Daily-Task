import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'scssApp';
  userDetail = [
    {name:'Jay Gohel', email:'jay@test.com'},
    {name:'Nisarg Patel', email:'nisarg0@test.com'},
    {name:'Kirti Rohit', email:'kirti@test.com'},
    {name:'Dev', email:'dev@test.com'}
  ]

  updateData(item:string){
    console.warn(item)
  }
}
