import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreeResourcesComponent } from './free-resources.component';

describe('FreeResourcesComponent', () => {
  let component: FreeResourcesComponent;
  let fixture: ComponentFixture<FreeResourcesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreeResourcesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreeResourcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
