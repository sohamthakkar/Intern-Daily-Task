import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  users(){
    return[
      {name:'jay', email:'jay@g.c',age:22 },
      {name:'Anil', email:'anil@g.c',age:20 },
      {name:'Sanjay', email:'sanjay@g.c',age:28 },
      {name:'Nisarg', email:'nisarg@g.c',age:30 }
    ]
  }

  constructor() { }
}
