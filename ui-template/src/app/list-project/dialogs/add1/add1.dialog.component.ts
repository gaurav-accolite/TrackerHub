import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {DataService2} from '../../services/data.service';
import {FormControl, Validators} from '@angular/forms';
import {Issue} from '../../models/issue';

@Component({
  selector: 'app-add1.dialog',
  templateUrl: '../../dialogs/add1/add1.dialog.html',
  styleUrls: ['../../dialogs/add1/add1.dialog.css']
})

export class Add1DialogComponent {
  selected = 'option2';

  constructor(public dialogRef: MatDialogRef<Add1DialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Issue,
              public dataService: DataService2) { }

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
