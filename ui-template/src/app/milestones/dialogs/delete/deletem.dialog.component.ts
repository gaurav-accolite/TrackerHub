import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {DatamService} from '../../services/m_data.service';


@Component({
  selector: 'app-deletem.dialog',
  templateUrl: '../../dialogs/delete/deletem.dialog.html',
  styleUrls: ['../../dialogs/delete/deletem.dialog.css']
})
export class DeletemDialogComponent {

  constructor(public dialogRef: MatDialogRef<DeletemDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: DatamService) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmDelete(): void {
    this.dataService.deleteIssue(this.data.id);
  }
}
