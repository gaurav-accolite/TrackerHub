import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { ListSowComponent } from '../../list-sow/list-sow.component';
import { CreateSowComponent } from '../../create-sow/create-sow.component';
import { ListProjectComponent } from '../../list-project/list-project.component';
import { CreateProjectComponent } from '../../create-project/create-project.component';
import { ManageResourcesComponent } from '../../manage-resources/manage-resources.component';
import { MilestonesComponent } from '../../milestones/milestones.component';

import {
  MatButtonModule,
  MatInputModule,
  MatRippleModule,
  MatTooltipModule,
} from '@angular/material';
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    MatButtonModule,
    MatRippleModule,
    MatInputModule,
    MatTooltipModule,
  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    TableListComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,
    ListSowComponent,
    CreateSowComponent,
    ListProjectComponent,
    CreateProjectComponent,
    ManageResourcesComponent,
    MilestonesComponent,
  ]
})

export class AdminLayoutModule {}
