import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {DatamService} from '../../services/m_data.service';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-bazam.dialog',
  templateUrl: '../../dialogs/edit/editm.dialog.html',
  styleUrls: ['../../dialogs/edit/editm.dialog.css']
})
export class EditmDialogComponent {

  constructor(public dialogRef: MatDialogRef<EditmDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public dataService: DatamService) { }

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
    this.dataService.updateIssue(this.data);
  }
}
