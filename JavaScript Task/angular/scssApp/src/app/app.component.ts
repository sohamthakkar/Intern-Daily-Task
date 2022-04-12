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
  // Switch case
  color= 'blue'


  //pip
  text = 'Angular tutorial'
  data = {
    name: 'jay',
    age : 22,
    email: 'jay@g.c'
  }
  arr:any[] = ['jay gohel', 'nisarg patel','Kirti', 'Ilse Lesure', 'dev Gatz', 'Alphonso Wellingford']
}

