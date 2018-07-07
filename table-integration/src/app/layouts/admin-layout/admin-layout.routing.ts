import { Routes } from '@angular/router';

import { ListSowComponent } from '../../list-sow/list-sow.component';
import { CreateSowComponent } from '../../create-sow/create-sow.component';
import { ListProjectComponent } from '../../list-project/list-project.component';
import { CreateProjectComponent } from '../../create-project/create-project.component';
import { ManageResourcesComponent } from '../../manage-resources/manage-resources.component';
import { MilestonesComponent } from '../../milestones/milestones.component';

export const AdminLayoutRoutes: Routes = [
    // {
    //   path: '',
    //   children: [ {
    //     path: 'dashboard',
    //     component: DashboardComponent
    // }]}, {
    // path: '',
    // children: [ {
    //   path: 'userprofile',
    //   component: UserProfileComponent
    // }]
    // }, {
    //   path: '',
    //   children: [ {
    //     path: 'icons',
    //     component: IconsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'notifications',
    //         component: NotificationsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'maps',
    //         component: MapsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'typography',
    //         component: TypographyComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'upgrade',
    //         component: UpgradeComponent
    //     }]
    // }
    // { path: 'dashboard',      component: DashboardComponent },
    // { path: 'user-profile',   component: UserProfileComponent },
    // { path: 'table-list',     component: TableListComponent },
    // { path: 'typography',     component: TypographyComponent },
    // { path: 'icons',          component: IconsComponent },
    // { path: 'maps',           component: MapsComponent },
    // { path: 'notifications',  component: NotificationsComponent },
    // { path: 'upgrade',        component: UpgradeComponent },
    { path: 'list-sow',         component: ListSowComponent },
    { path: 'create-sow',       component: CreateSowComponent },
    { path: 'list-project',     component: ListProjectComponent },
    { path: 'create-project',   component: CreateProjectComponent },
    { path: 'manage-resources', component: ManageResourcesComponent },
    { path: 'milestones',       component: MilestonesComponent },
];