import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/list-sow', title: 'Statement of Work',  icon: 'dashboard', class: '' },
//    { path: '/create-sow', title: 'Create SoW',  icon:'person', class: '' },
    { path: '/list-project', title: 'Projects',  icon:'content_paste', class: '' },
    { path: '/manage-resources', title: 'Manage Resources',  icon:'bubble_chart', class: '' },
    { path: '/milestones', title: 'Milestones',  icon:'location_on', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
