import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Issue} from '../models/issue';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';

@Injectable()
export class DataService {
//  private readonly API_URL = 'https://api.github.com/repos/angular/angular/issues';

    //private readonly API_URL = 'https://jsonplaceholder.typicode.com/posts';

  private readonly API_URL = 'http://10.4.15.45:8081/api/sow/getAllSOW';
//private readonly API_URL = 'http://localhost:3000/posts';
  dataChange: BehaviorSubject<Issue[]> = new BehaviorSubject<Issue[]>([]);
  // Temporarily stores data from dialogs
  dialogData: any;

  constructor (private httpClient: HttpClient) {}

  get data(): Issue[] {
    return this.dataChange.value;
  }

  getDialogData() {
    return this.dialogData;
  }

  /** CRUD METHODS */
  getAllIssues(): void {
    this.httpClient.get<Issue[]>(this.API_URL).subscribe(data => {
        this.dataChange.next(data);
      },
      (error: HttpErrorResponse) => {
      console.log (error.name + ' ' + error.message);
      });
  }

  // DEMO ONLY, you can find working methods below
  addIssue (issue: Issue): void {
    this.dialogData = issue;
    this.addItem(issue);
  }

  updateIssue (issue: Issue): void {
    this.dialogData = issue;
    this.updateItem(issue);
  }

  deleteIssue (id: number): void {
    console.log(id);
    this.deleteItem(id);
  }

  
     // ADD, POST METHOD
     addItem(issue: Issue): void {
       this.httpClient.post("http://10.4.15.45:8081/api/sow/", issue).subscribe(data => {
        this.dialogData = issue;
        },
        (err: HttpErrorResponse) => {
      });
     }

     updateItem(issue: Issue): void {
      this.httpClient.put("http://10.4.15.45:8081/api/sow/updateSow/" + issue.id, issue).subscribe(data => {
          this.dialogData = issue;
        },
        (err: HttpErrorResponse) => {
        }
      );
    }


      // DELETE METHOD
  deleteItem(id: number): void {
    this.httpClient.delete("http://10.4.15.45:8081/api/sow/deleteSow/" + id).subscribe(data => {
      console.log(data['']);
      },
      (err: HttpErrorResponse) => {
      }
    );
  }

}


 
/*
    // UPDATE, PUT METHOD
     updateItem(kanbanItem: KanbanItem): void {
    this.httpClient.put(this.API_URL + kanbanItem.id, kanbanItem).subscribe(data => {
        this.dialogData = kanbanItem;
        this.toasterService.showToaster('Successfully edited', 3000);
      },
      (err: HttpErrorResponse) => {
        this.toasterService.showToaster('Error occurred. Details: ' + err.name + ' ' + err.message, 8000);
      }
    );
  }

  // DELETE METHOD
  deleteItem(id: number): void {
    this.httpClient.delete(this.API_URL + id).subscribe(data => {
      console.log(data['']);
        this.toasterService.showToaster('Successfully deleted', 3000);
      },
      (err: HttpErrorResponse) => {
        this.toasterService.showToaster('Error occurred. Details: ' + err.name + ' ' + err.message, 8000);
      }
    );
  }
*/




