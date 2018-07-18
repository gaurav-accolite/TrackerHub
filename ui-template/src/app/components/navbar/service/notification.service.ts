import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { map } from 'rxjs/operators';

@Injectable()
export class NotificationService {

  private readonly URL : string = 'http://localhost:3007/posts';

  constructor(public http : Http) { }

  getInfo() {
    return this.http.get(this.URL).pipe(map(res => res.json()));
  }

}
