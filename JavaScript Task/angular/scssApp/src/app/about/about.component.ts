import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  constructor(private route:ActivatedRoute) { }

  userId:any=''
  ngOnInit(): void {
    console.log("id is: ",this.route.snapshot.paramMap.get('id'));
    this.userId= this.route.snapshot.paramMap.get('id');
  }

}
