import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EngagedResourcesComponent } from './engaged-resources.component';

describe('EngagedResourcesComponent', () => {
  let component: EngagedResourcesComponent;
  let fixture: ComponentFixture<EngagedResourcesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EngagedResourcesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EngagedResourcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
