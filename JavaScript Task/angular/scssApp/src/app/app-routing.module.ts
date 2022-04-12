import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes } from "@angular/router";
import {AboutComponent} from "./about/about.component";
import {TodoComponent} from "./todo/todo.component";
import {HomeComponent} from "./home/home.component";
import {UserFromComponent} from "./user-from/user-from.component";
import {NoPageComponent} from "./no-page/no-page.component";


const  routes:Routes=[

  {
    path:'about',
    component: AboutComponent
  },
  {
    path:'todo',
    component: TodoComponent
  },
  {
    path:'user',
    component: UserFromComponent
  },
  {
    path:'home',
    component: HomeComponent
  },
  {
    path:'**',
    component: NoPageComponent
  }

]


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
