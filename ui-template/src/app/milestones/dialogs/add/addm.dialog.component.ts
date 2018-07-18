import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {DatamService} from '../../services/m_data.service';
import {FormControl, Validators} from '@angular/forms';
import {Issue} from '../../models/m_issue';

@Component({
  selector: 'app-addm.dialog',
  templateUrl: '../../dialogs/add/addm.dialog.html',
  styleUrls: ['../../dialogs/add/addm.dialog.css']
})

export class AddmDialogComponent {
  constructor(public dialogRef: MatDialogRef<AddmDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Issue,
              public dataService: DatamService) { }

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

  public confirmAdd(): void {
    this.dataService.addIssue(this.data);
  }
}
