import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Issue} from '../models/m_issue';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';

@Injectable()
export class DatamService {
  private readonly API_URL = 'http://10.4.15.45:8081/api/milestone/';

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
    this.httpClient.post(this.API_URL, issue).subscribe(data => {
        this.dialogData = issue;
        },
        (err: HttpErrorResponse) => {
      });
  }

  updateIssue (issue: Issue): void {
    this.httpClient.put(this.API_URL, issue).subscribe(data => {
          this.dialogData = issue;
        },
        (err: HttpErrorResponse) => {
        }
      );
  }

  deleteIssue (id: number): void {
    this.httpClient.delete(this.API_URL + id).subscribe(data => {
        console.log(data['']);
        },
        (err: HttpErrorResponse) => {
        }
      );
  }
}



// // REAL LIFE CRUD Methods I've used in my projects. ToasterService uses Material Toasts for displaying messages:

//     // ADD, POST METHOD
//     addItem(issue: Issue): void {
//     this.httpClient.post(this.API_URL, issue).subscribe(data => {
//       this.dialogData = issue;
//       this.toasterService.showToaster('Successfully added', 3000);
//       },
//       (err: HttpErrorResponse) => {
//       this.toasterService.showToaster('Error occurred. Details: ' + err.name + ' ' + err.message, 8000);
//     });
//    }

//     // UPDATE, PUT METHOD
//      updateItem(issue: Issue): void {
//     this.httpClient.put(this.API_URL, issue).subscribe(data => {
//         this.dialogData = issue;
//         this.toasterService.showToaster('Successfully edited', 3000);
//       },
//       (err: HttpErrorResponse) => {
//         this.toasterService.showToaster('Error occurred. Details: ' + err.name + ' ' + err.message, 8000);
//       }
//     );
//   }

//   // DELETE METHOD
//   deleteItem(id: number): void {
//     this.httpClient.delete(this.API_URL + id).subscribe(data => {
//       console.log(data['']);
//         this.toasterService.showToaster('Successfully deleted', 3000);
//       },
//       (err: HttpErrorResponse) => {
//         this.toasterService.showToaster('Error occurred. Details: ' + err.name + ' ' + err.message, 8000);
//       }
//     );
//   }





