import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { map } from 'rxjs/operators';

@Injectable()
export class SowServiceService {

  private readonly API_URL = 'http://localhost:3002/posts/';

  constructor(private http:Http) {

  }

  getSOW() {
    return this.http.get(this.API_URL).pipe(map(res => res.json()));
  }

}
