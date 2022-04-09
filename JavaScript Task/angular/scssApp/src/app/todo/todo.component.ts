import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  taskName = ''

  taskList:any[]=[]

  addTask(task: string) {
    this.taskName = task
    console.warn(this.taskName)
    this.taskList.push({id: this.taskList.length, name:task})
    console.warn(this.taskList)
  }

  removeTask(id: number) {
    this.taskList = this.taskList.filter(item=>item.id !==id)
  }
}
