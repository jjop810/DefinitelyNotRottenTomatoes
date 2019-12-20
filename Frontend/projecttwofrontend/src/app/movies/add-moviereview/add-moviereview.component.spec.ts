import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMoviereviewComponent } from './add-moviereview.component';

describe('AddMoviereviewComponent', () => {
  let component: AddMoviereviewComponent;
  let fixture: ComponentFixture<AddMoviereviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMoviereviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMoviereviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
