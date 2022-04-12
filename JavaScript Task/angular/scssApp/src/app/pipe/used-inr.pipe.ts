import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'usedInr' })
export class UsedInrPipe implements PipeTransform {

  transform(value: string, ...args:unknown[]): any {
    if (value.length > 6){

      return value.slice(0,6)+'....';
    }else {
      return value;
    }
  }

}
