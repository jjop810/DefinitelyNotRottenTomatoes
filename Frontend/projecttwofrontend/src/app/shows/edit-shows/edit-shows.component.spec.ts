import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditShowsComponent } from './edit-shows.component';

describe('EditShowsComponent', () => {
  let component: EditShowsComponent;
  let fixture: ComponentFixture<EditShowsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditShowsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditShowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
