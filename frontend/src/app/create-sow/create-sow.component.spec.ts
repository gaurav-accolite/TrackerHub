import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSowComponent } from './create-sow.component';

describe('CreateSowComponent', () => {
  let component: CreateSowComponent;
  let fixture: ComponentFixture<CreateSowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
