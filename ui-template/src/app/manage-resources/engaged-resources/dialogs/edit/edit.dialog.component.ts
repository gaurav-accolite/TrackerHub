import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {ERDataService} from '../../services/data.service';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';
import {FormControl, Validators} from '@angular/forms';
import {Issue} from '../../models/issue';

@Component({
  selector: 'app-baza.dialog',
  templateUrl: '../../dialogs/edit/edit.dialog.html',
  styleUrls: ['../../dialogs/edit/edit.dialog.css']
})
export class EREditDialogComponent {

  minDate : Date;
  issue : Issue;
  endDate : string;

  constructor(public dialogRef: MatDialogRef<EREditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: ERDataService) {
                this.minDate = new Date(data.start_date);
              }

  formControl = new FormControl('', [
    Validators.required
    // Validators.email,
  ]);

  getErrorMessage() {
    return this.formControl.hasError('required') ? 'Required field' :
      this.formControl.hasError('email') ? 'Not a valid email' :
        '';
  }

  submit() {
    // emppty stuff
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  stopEdit(): void {
    this.issue = this.data;
    this.issue.end_date = this.endDate;
    this.dataService.addIssue(this.issue);
    console.log(this.issue);
  }

  addEvent(event: MatDatepickerInputEvent<Date>): void {
    this.endDate = (event.value.getMonth()+1)+"/"+event.value.getDate()+"/"+event.value.getFullYear();
  }
}
