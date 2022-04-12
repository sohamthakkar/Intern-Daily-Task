import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSliderModule} from "@angular/material/slider";
import {TodoComponent} from './todo/todo.component';
import {UserDetailComponent} from './user-detail/user-detail.component';
import {ChildComponent} from './child/child.component';
import {UsedInrPipe} from './pipe/used-inr.pipe';
import {UserFromComponent} from './user-from/user-from.component';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import { ShowFormComponent } from './show-form/show-form.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { NoPageComponent } from './no-page/no-page.component';
import { ShowUserComponent } from './show-user/show-user.component';

const declarations = [
  AppComponent,
  HeaderComponent,
  TodoComponent,
  UserDetailComponent,
  ChildComponent,
  UsedInrPipe,
  UserFromComponent
]

const imports = [
  BrowserModule,
  AppRoutingModule,
  BrowserAnimationsModule,
  MatSliderModule,
  FormsModule
]

@NgModule({
  declarations: [...declarations, ShowFormComponent, HomeComponent, AboutComponent, NoPageComponent, ShowUserComponent],
  imports: [...imports],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
