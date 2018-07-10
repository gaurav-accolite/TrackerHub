import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule, MatDialogModule, MatIconModule, MatInputModule, MatPaginatorModule, MatSortModule,
  MatTableModule, MatToolbarModule, MatTabsModule, MatDatepickerModule, MatSelectModule
} from '@angular/material';
import {DataService} from './list-sow/services/data.service';
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
// import { DashboardComponent } from './dashboard/dashboard.component';
// import { UserProfileComponent } from './user-profile/user-profile.component';
// import { TableListComponent } from './table-list/table-list.component';
// import { TypographyComponent } from './typography/typography.component';
// import { IconsComponent } from './icons/icons.component';
// import { MapsComponent } from './maps/maps.component';
// import { NotificationsComponent } from './notifications/notifications.component';
// import { UpgradeComponent } from './upgrade/upgrade.component';
import { AgmCoreModule } from '@agm/core';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
// import { ListSowComponent } from './list-sow/list-sow.component';
// import { CreateSowComponent } from './create-sow/create-sow.component';
// import { ListProjectComponent } from './list-project/list-project.component';
// import { CreateProjectComponent } from './create-project/create-project.component';
// import { ManageResourcesComponent } from './manage-resources/manage-resources.component';
// import { MilestonesComponent } from './milestones/milestones.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,

    HttpClientModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatSortModule,
    MatTableModule,
    MatToolbarModule,
    MatTabsModule,
    MatPaginatorModule,
    MatDatepickerModule,
    MatSelectModule,
    ReactiveFormsModule,

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
    AddDialogComponent,
    EditDialogComponent,
    DeleteDialogComponent,
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
    EditDialogComponent,
    DeleteDialogComponent,
    ERAddDialogComponent,
    EREditDialogComponent,
    AdminLayoutComponent,
    ERDeleteDialogComponent,
    FRAddDialogComponent,
    FREditDialogComponent,
    FRDeleteDialogComponent
    // ListSowComponent,
    // CreateSowComponent,
    // ListProjectComponent,
    // CreateProjectComponent,
    // ManageResourcesComponent,
    // MilestonesComponent,

  ],
  providers: [DataService,
              ERDataService,
              FRDataService,
              SowServiceService
            ],
  bootstrap: [AppComponent]
})
export class AppModule { }
