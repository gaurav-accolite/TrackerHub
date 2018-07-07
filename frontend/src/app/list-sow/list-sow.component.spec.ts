import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSowComponent } from './list-sow.component';

describe('ListSowComponent', () => {
  let component: ListSowComponent;
  let fixture: ComponentFixture<ListSowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListSowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
