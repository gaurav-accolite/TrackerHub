import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import {FileUploadModule} from 'ng2-file-upload';

import {HttpClientModule} from '@angular/common/http';
import {
  MatDatepickerModule,
  MatButtonModule, MatDialogModule, MatIconModule, MatInputModule, MatPaginatorModule, MatSortModule,
  MatTableModule, MatToolbarModule, MatSelectModule, MatOptionModule,
} from '@angular/material';


import {Add1DialogComponent} from './list-project/dialogs/add1/add1.dialog.component';
import {Edit1DialogComponent} from './list-project/dialogs/edit1/edit1.dialog.component';
import {Delete1DialogComponent} from './list-project/dialogs/delete1/delete1.dialog.component';
import { AddmDialogComponent } from './milestones/dialogs/add/addm.dialog.component';
import {DatamService} from './milestones/services/m_data.service';
import {EditmDialogComponent} from './milestones/dialogs/edit/editm.dialog.component';
import {DeletemDialogComponent} from './milestones/dialogs/delete/deletem.dialog.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { TableListComponent } from './table-list/table-list.component';
import { TypographyComponent } from './typography/typography.component';
import { IconsComponent } from './icons/icons.component';
import { MapsComponent } from './maps/maps.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UpgradeComponent } from './upgrade/upgrade.component';
import {
  AgmCoreModule
} from '@agm/core';
import { DataService2 } from './list-project/services/data.service';
import {DataService} from './list-sow/services/data.service';
import {UploadFileService} from './list-sow/dialogs/add/upload.service';

import {ERDataService} from './manage-resources/engaged-resources/services/data.service'
import {FRDataService} from './manage-resources/free-resources/services/data.service';
import {SowServiceService} from './manage-resources/free-resources/services/sow-service.service';
import {AddDialogComponent} from './list-sow/dialogs/add/add.dialog.component';
import {EditDialogComponent} from './list-sow/dialogs/edit/edit.dialog.component';
import {DeleteDialogComponent} from './list-sow/dialogs/delete/delete.dialog.component';
import {ERAddDialogComponent} from './manage-resources/engaged-resources/dialogs/add/add.dialog.component';
import {EREditDialogComponent} from './manage-resources/engaged-resources/dialogs/edit/edit.dialog.component';
import {ERDeleteDialogComponent} from './manage-resources/engaged-resources/dialogs/delete/delete.dialog.component';
import {FRAddDialogComponent} from './manage-resources/free-resources/dialogs/add/add.dialog.component';
import {FREditDialogComponent} from './manage-resources/free-resources/dialogs/edit/edit.dialog.component';
import {FRDeleteDialogComponent} from './manage-resources/free-resources/dialogs/delete/delete.dialog.component';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { NotificationService } from './components/navbar/service/notification.service';

@NgModule({
  imports: [

    MatDatepickerModule,
    BrowserAnimationsModule,
    FileUploadModule,
    HttpClientModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatSortModule,
    MatTableModule,
    MatToolbarModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatOptionModule,

    FormsModule,
    HttpModule,
    ComponentsModule,
    RouterModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    })
  ],
  entryComponents: [
    AddmDialogComponent,
    EditmDialogComponent,
    DeletemDialogComponent,
    AddDialogComponent,
    EditDialogComponent,
    DeleteDialogComponent,
    Add1DialogComponent,
    Edit1DialogComponent,
    Delete1DialogComponent,
    ERAddDialogComponent,
    EREditDialogComponent,
    ERDeleteDialogComponent,
    FRAddDialogComponent,
    FREditDialogComponent,
    FRDeleteDialogComponent
  ],

  declarations: [
    AppComponent,
    AddDialogComponent,
    AddmDialogComponent,
    EditDialogComponent,
    DeleteDialogComponent,
    AdminLayoutComponent,
    Add1DialogComponent,
    EditmDialogComponent,
    DeletemDialogComponent,
    Edit1DialogComponent,
    Delete1DialogComponent,
    AppComponent,
    AddDialogComponent,
    EditDialogComponent,
    DeleteDialogComponent,
    ERAddDialogComponent,
    EREditDialogComponent,
    AdminLayoutComponent,
    ERDeleteDialogComponent,
    FRAddDialogComponent,
    FREditDialogComponent,
    FRDeleteDialogComponent
  ],
  providers: [DataService, DataService2, ERDataService, UploadFileService,
    FRDataService, SowServiceService, DatamService, NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule {
 }
