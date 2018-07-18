import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {DataService2} from '../../services/data.service';


@Component({
  selector: 'app-delete.dialog',
  templateUrl: '../../dialogs/delete1/delete1.dialog.html',
  styleUrls: ['../../dialogs/delete1/delete1.dialog.css']
})
export class Delete1DialogComponent {

  constructor(public dialogRef: MatDialogRef<Delete1DialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: DataService2) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmDelete(): void {
    this.dataService.deleteIssue(this.data.id);
  }
}
