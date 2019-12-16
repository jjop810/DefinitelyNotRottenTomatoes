import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShowsComponent } from './add-shows.component';

describe('AddShowsComponent', () => {
  let component: AddShowsComponent;
  let fixture: ComponentFixture<AddShowsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddShowsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddShowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
