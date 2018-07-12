import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {FRDataService} from '../../services/data.service';
import {FormControl, Validators} from '@angular/forms';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';
import {SowServiceService} from '../../services/sow-service.service';
import {Issue} from '../../models/issue';

@Component({
  selector: 'app-baza.dialog',
  templateUrl: '../../dialogs/edit/edit.dialog.html',
  styleUrls: ['../../dialogs/edit/edit.dialog.css']
})
export class FREditDialogComponent {

  startDate : Date;
  endDate : Date;
  issue : Issue;
  sowDetails : SoWDetails[];
  projectDetails : Projects[];

  constructor(public dialogRef: MatDialogRef<FREditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: FRDataService,
              public sowService : SowServiceService) {
                this.startDate = new Date();
                this.sowService.getSOW().subscribe((sowDetails) => {
                  this.sowDetails = sowDetails; console.log(this.sowDetails); 
                });
               }

  formControl = new FormControl('', [
    Validators.required
    // Validators.email
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
    this.issue.start_date = this.startDate.getTime();
    this.issue.end_date = this.endDate.getTime();
    this.dataService.updateIssue(this.issue);
    console.log(this.issue);
  }

  addEvent(event: MatDatepickerInputEvent<Date>): void {
    console.log(event.value);
    this.startDate = event.value;
  }

  addEndEvent(event: MatDatepickerInputEvent<Date>): void {
    console.log(event.value);
    this.endDate = event.value;
  }

  changeEvent(value : any)
  {
    console.log(value);
    for(var i=0;i<this.sowDetails.length;i++) {
        if(value === this.sowDetails[i].sow_id) {
          this.projectDetails = this.sowDetails[i].projects;
        }
    }
  }
}

interface SoWDetails {
  projects : Projects[],
  sow_id : number,
  sow_name : string
}
interface Projects{
  project_id : number,
  project_name : string
}