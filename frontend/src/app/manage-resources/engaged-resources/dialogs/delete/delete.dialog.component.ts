import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {ERDataService} from '../../services/data.service';


@Component({
  selector: 'app-delete.dialog',
  templateUrl: '../../dialogs/delete/delete.dialog.html',
  styleUrls: ['../../dialogs/delete/delete.dialog.css']
})
export class ERDeleteDialogComponent {

  constructor(public dialogRef: MatDialogRef<ERDeleteDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: ERDataService) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmDelete(): void {
    this.dataService.deleteIssue(this.data.id);
  }
}
