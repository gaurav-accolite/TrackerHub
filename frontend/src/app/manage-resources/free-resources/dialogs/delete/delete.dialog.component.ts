import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {FRDataService} from '../../services/data.service';


@Component({
  selector: 'app-delete.dialog',
  templateUrl: '../../dialogs/delete/delete.dialog.html',
  styleUrls: ['../../dialogs/delete/delete.dialog.css']
})
export class FRDeleteDialogComponent {

  constructor(public dialogRef: MatDialogRef<FRDeleteDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: FRDataService) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmDelete(): void {
    this.dataService.deleteIssue(this.data.id);
  }
}
