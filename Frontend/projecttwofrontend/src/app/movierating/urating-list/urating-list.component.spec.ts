import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UratingListComponent } from './urating-list.component';

describe('UratingListComponent', () => {
  let component: UratingListComponent;
  let fixture: ComponentFixture<UratingListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UratingListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UratingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
